package in.anandm.oj.service;

import in.anandm.oj.model.Problem;
import in.anandm.oj.model.TestCase;
import in.anandm.oj.repository.ProblemRepository;
import in.anandm.oj.repository.TestCaseRepository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.context.ApplicationContextException;
import org.springframework.web.multipart.MultipartFile;

public class ProblemUploadHelper {

    private enum FileType {
        PROBLEM_STATEMENT, TEST_INPUT, TEST_OUTPUT, CONSTRAINTS;
    }

    private PathHelper pathHelper;

    private ProblemRepository problemRepository;

    private TestCaseRepository testCaseRepository;

    /**
     * @param pathHelper
     * @param problemRepository
     * @param testCaseRepository
     */
    public ProblemUploadHelper(PathHelper pathHelper,
            ProblemRepository problemRepository,
            TestCaseRepository testCaseRepository) {
        super();
        this.pathHelper = pathHelper;
        this.problemRepository = problemRepository;
        this.testCaseRepository = testCaseRepository;
    }

    public Problem uploadProblem(MultipartFile problemFile) {
        try {

            String problemDirectoryPath = pathHelper.directoryPath();

            File problemDirectory = new File(
                    pathHelper.absoluteDirectoryPath(problemDirectoryPath));

            problemDirectory.mkdirs();

            ZipInputStream zipInputStream = new ZipInputStream(
                    problemFile.getInputStream());

            ZipEntry zipEntry = null;

            Problem problem = new Problem();

            Map<Integer, TestCase> testCases = new TreeMap<Integer, TestCase>();

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                if (zipEntry.isDirectory()) {
                    continue;
                }

                String entryName = zipEntry.getName().substring(
                        zipEntry.getName().indexOf("/") + 1,
                        zipEntry.getName().length());

                FileType fileType = fileType(entryName);

                switch (fileType) {
                case PROBLEM_STATEMENT:
                    processProblemStatementFile(problem, zipInputStream);
                    break;
                case TEST_INPUT:

                    processTestInputFile(
                            testCases, problemDirectoryPath, entryName,
                            zipInputStream);

                    break;

                case TEST_OUTPUT:

                    processTestOutputFile(
                            testCases, problemDirectoryPath, entryName,
                            zipInputStream);
                    break;
                case CONSTRAINTS:

                    processConstraintsFile(problem, zipInputStream);

                    break;
                default:
                    break;
                }
            }

            zipInputStream.close();

            // save problem

            problemRepository.saveProblem(problem);

            for (TestCase testCase : testCases.values()) {
                testCase.setProblem(problem);

                testCaseRepository.saveTestCase(testCase);
            }

            return problem;

        }
        catch (IOException e) {

            throw new ApplicationContextException("failed to upload problem", e);
        }
    }

    private void processConstraintsFile(Problem problem,
                                        ZipInputStream zipInputStream)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                zipInputStream));
        String line = null;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("=");
            if (tokens[0].equalsIgnoreCase("TL")) {
                problem.setMaxTimeLimit(Long.parseLong(tokens[1]));
            }

            if (tokens[0].equalsIgnoreCase("ML")) {
                problem.setMaxMemoryLimit(Long.parseLong(tokens[1]));
            }

            if (tokens[0].equalsIgnoreCase("SSL")) {
                problem.setMaxSolutionSizeLimit(Long.parseLong(tokens[1]));
            }
        }
    }

    private void processProblemStatementFile(Problem problem,
                                             ZipInputStream zipInputStream)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                zipInputStream));
        String line = null;
        StringBuilder problemStatementBuilder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            problemStatementBuilder.append(line);
        }

        problem.setProblemStatement(problemStatementBuilder.toString());
    }

    private void processTestInputFile(Map<Integer, TestCase> testCases,
                                      String problemDirectoryPath,
                                      String entryName,
                                      ZipInputStream zipInputStream)
            throws IOException {

        String filePath = pathHelper.filePath(problemDirectoryPath, entryName);

        BufferedInputStream is = new BufferedInputStream(zipInputStream);

        BufferedOutputStream os = new BufferedOutputStream(
                new FileOutputStream(new File(
                        pathHelper.absoluteFilePath(filePath))));

        byte[] buffer = new byte[1024];

        int len = 0;

        while ((len = is.read(buffer)) > 0) {
            os.write(buffer, 0, len);
        }

        os.close();

        int index = index(entryName);

        TestCase testCase = testCases.get(index);

        if (testCase == null) {
            testCase = new TestCase();
        }

        testCase.setInputFilePath(filePath);

        testCases.put(index, testCase);
    }

    private void processTestOutputFile(Map<Integer, TestCase> testCases,
                                       String problemDirectoryPath,
                                       String entryName,
                                       ZipInputStream zipInputStream)
            throws IOException {

        String filePath = pathHelper.filePath(problemDirectoryPath, entryName);

        BufferedInputStream is = new BufferedInputStream(zipInputStream);

        BufferedOutputStream os = new BufferedOutputStream(
                new FileOutputStream(new File(
                        pathHelper.absoluteFilePath(filePath))));

        byte[] buffer = new byte[1024];

        int len = 0;

        while ((len = is.read(buffer)) > 0) {
            os.write(buffer, 0, len);
        }

        os.close();

        int index = index(entryName);

        TestCase testCase = testCases.get(index);

        if (testCase == null) {
            testCase = new TestCase();
        }

        testCase.setOutputFilePath(filePath);

        testCases.put(index, testCase);
    }

    private int index(String entryName) {

        return Integer.parseInt(entryName.substring(4, entryName.indexOf(".")));
    }

    private FileType fileType(String entryName) {

        if (entryName.matches("^test[0-9]*\\.in\\.txt$")) {
            return FileType.TEST_INPUT;
        }

        if (entryName.matches("^test[0-9]*\\.out\\.txt$")) {
            return FileType.TEST_OUTPUT;
        }

        if (entryName.equalsIgnoreCase("constraints.txt")) {
            return FileType.CONSTRAINTS;
        }

        if (entryName.equalsIgnoreCase("statement.md")) {
            return FileType.PROBLEM_STATEMENT;
        }

        return null;
    }
}
