package in.anandm.oj.model;

import in.anandm.oj.repository.EvaluationResultRepository;
import in.anandm.oj.repository.SolutionRepository;
import in.anandm.oj.repository.TestCaseRepository;
import in.anandm.oj.service.PathHelper;
import in.anandm.oj.utils.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class JavaJudge extends AbstractJudge {

    /**
     * @param pathHelper
     * @param testCaseRepository
     * @param evaluationResultRepository
     * @param solutionRepository
     */
    public JavaJudge(PathHelper pathHelper,
            TestCaseRepository testCaseRepository,
            EvaluationResultRepository evaluationResultRepository,
            SolutionRepository solutionRepository) {
        super(pathHelper, testCaseRepository, evaluationResultRepository,
                solutionRepository);

    }

    @Override
    public String sourceFileName() {

        return "Main.java";
    }

    @Override
    public String executableFileName() {

        return "Main";
    }

    @Override
    public String compile(String stagingDirectoryPath) {
        try {

            ProcessBuilder processBuilder = new ProcessBuilder("javac",
                    sourceFileName());

            processBuilder.directory(new File(pathHelper
                    .absoluteStagingDirectoryPath(stagingDirectoryPath)));

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));

            int exitCode = process.waitFor();

            StringBuilder builder = new StringBuilder();

            if (exitCode != 0) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            }

            reader.close();

            process.destroy();

            return builder.toString();
        }
        catch (Exception e) {
            throw new ApplicationException("failed to compile staging area : "
                    + stagingDirectoryPath, e);
        }
    }

    @Override
    public EvaluationResultStatus test(String stagingDirectoryPath,
                                       TestCase testCase,
                                       long timeLimit,
                                       long memoryLimit) {
        try {

            String outputFileName = testCase.getId() + ".out.txt";

            String outputFilePath = pathHelper.stagingFilePath(
                    stagingDirectoryPath, outputFileName);

            String scriptFilePath = pathHelper.stagingFilePath(
                    stagingDirectoryPath, "run.bat");

            File runScript = new File(
                    pathHelper.absoluteStagingFilePath(scriptFilePath));

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(runScript));
            writer.write("echo off");
            writer.write(System.getProperty("line.separator"));
            writer.write("java " + executableFileName() + " < "
                    + pathHelper.absoluteFilePath(testCase.getInputFilePath())
                    + " > " + outputFileName);
            writer.close();

            ProcessBuilder processBuilder = new ProcessBuilder(
                    pathHelper.absoluteStagingFilePath(scriptFilePath));

            processBuilder.directory(new File(pathHelper
                    .absoluteStagingDirectoryPath(stagingDirectoryPath)));

            final Process process = processBuilder.start();

            final List<Boolean> timeOut = new ArrayList<Boolean>(1);
            timeOut.add(0, Boolean.FALSE);

            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {

                @Override
                public void run() {

                    try {
                        process.exitValue();
                    }
                    catch (IllegalThreadStateException e) {
                        process.destroy();
                        timeOut.add(0, Boolean.TRUE);
                    }

                    timer.cancel();

                }
            }, timeLimit);

            int exitCode = -1;

            try {
                exitCode = process.waitFor();

                timer.cancel();
                process.destroy();
            }
            catch (InterruptedException e) {
                // ignore
            }
            if (exitCode == 0) {
                File result = new File(
                        pathHelper.absoluteStagingFilePath(outputFilePath));

                File expected = new File(pathHelper.absoluteFilePath(testCase
                        .getOutputFilePath()));

                if (FileUtils.hasSameContent(result, expected)) {
                    return EvaluationResultStatus.AC;
                }
                else {
                    return EvaluationResultStatus.WO;
                }

            }
            else {
                if (timeOut.get(0)) {
                    return EvaluationResultStatus.TLE;
                }
                else {
                    return EvaluationResultStatus.RE;
                }

            }
        }
        catch (Exception e) {
            throw new ApplicationException(
                    "failed to execute test case, staging area : "
                            + stagingDirectoryPath + " , test case id : "
                            + testCase.getId(), e);
        }
    }
}
