package in.anandm.oj.model;

import in.anandm.oj.repository.EvaluationResultRepository;
import in.anandm.oj.repository.SolutionRepository;
import in.anandm.oj.repository.TestCaseRepository;
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
     * @param testCaseRepository
     * @param evaluationResultRepository
     * @param solutionRepository
     */
    public JavaJudge(TestCaseRepository testCaseRepository,
            EvaluationResultRepository evaluationResultRepository,
            SolutionRepository solutionRepository) {
        super(testCaseRepository, evaluationResultRepository,
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
    public String compile(File stagingArea) {
        try {

            ProcessBuilder processBuilder = new ProcessBuilder("javac",
                    sourceFileName());

            processBuilder.directory(stagingArea);

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
                    + stagingArea, e);
        }
    }

    @Override
    public EvaluationResultStatus test(File stagingArea, TestCase testCase) {
        try {
            String outputFileName = testCase.getId() + ".out.txt";

            File runScript = new File(stagingArea + File.separator + "run.bat");
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(runScript));
            writer.write("java " + executableFileName() + " < "
                    + testCase.getInputFilePath() + " > " + outputFileName);
            writer.close();

            ProcessBuilder processBuilder = new ProcessBuilder("run.bat");

            processBuilder.directory(stagingArea);

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
            }, testCase.getMaxTimeLimit());

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
                File result = new File(stagingArea + File.separator
                        + outputFileName);

                File expected = new File(testCase.getOutputFilePath());

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
                            + stagingArea + " , test case id : "
                            + testCase.getId(), e);
        }
    }
}
