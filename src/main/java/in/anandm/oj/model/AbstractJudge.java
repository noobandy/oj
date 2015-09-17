package in.anandm.oj.model;

import in.anandm.oj.repository.EvaluationResultRepository;
import in.anandm.oj.repository.SolutionRepository;
import in.anandm.oj.repository.TestCaseRepository;
import in.anandm.oj.service.PathHelper;
import in.anandm.oj.utils.FileUtils;

import java.io.File;
import java.util.Date;
import java.util.List;

public abstract class AbstractJudge implements Judge {

    protected PathHelper pathHelper;

    protected TestCaseRepository testCaseRepository;

    protected EvaluationResultRepository evaluationResultRepository;

    protected SolutionRepository solutionRepository;

    /**
     * @param pathHelper
     * @param testCaseRepository
     * @param evaluationResultRepository
     * @param solutionRepository
     */
    public AbstractJudge(PathHelper pathHelper,
            TestCaseRepository testCaseRepository,
            EvaluationResultRepository evaluationResultRepository,
            SolutionRepository solutionRepository) {
        super();
        this.pathHelper = pathHelper;
        this.testCaseRepository = testCaseRepository;
        this.evaluationResultRepository = evaluationResultRepository;
        this.solutionRepository = solutionRepository;
    }

    @Override
    public Solution evaluate(Solution solution) {
        String stagingDirectoryPath = solution.getId();
        try {

            File stagingArea = new File(
                    pathHelper
                            .absoluteStagingDirectoryPath(stagingDirectoryPath));
            // create directory
            stagingArea.mkdirs();

            // copy the solution to staging area

            File source = new File(pathHelper.absoluteFilePath(solution
                    .getSolutionFilePath()));

            String stagingFilePath = pathHelper.stagingFilePath(
                    stagingDirectoryPath, sourceFileName());

            File destination = new File(
                    pathHelper.absoluteStagingFilePath(stagingFilePath));

            FileUtils.copyFile(source, destination, 1024);

            // compile the solution
            String compilationErrors = compile(stagingDirectoryPath);

            EvaluationResultStatus resultStatus = EvaluationResultStatus.AC;

            if ("".equals(compilationErrors.trim())) {
                // compiled successfully
                Problem problem = solution.getProblem();

                List<TestCase> testCases = testCaseRepository
                        .getAllTestCasesOfProblem(problem);

                for (TestCase testCase : testCases) {

                    EvaluationResultStatus status = test(
                            stagingDirectoryPath, testCase,
                            problem.getMaxTimeLimit(),
                            problem.getMaxMemoryLimit());

                    if (status == EvaluationResultStatus.MLE
                            || status == EvaluationResultStatus.TLE
                            || status == EvaluationResultStatus.RE) {

                        resultStatus = status;
                    }

                    EvaluationResult evaluationResult = new EvaluationResult();
                    evaluationResult.setSolution(solution);
                    evaluationResult.setStatus(status);
                    evaluationResult.setTestCase(testCase);

                    evaluationResultRepository
                            .saveEvaluationResult(evaluationResult);

                }

            }
            else {
                resultStatus = EvaluationResultStatus.CE;
            }

            solution.setEvaluatedAt(new Date());
            solution.setStatus(resultStatus);
            solution.setCompilationErrors(compilationErrors);

            solutionRepository.saveSolution(solution);

            return solution;
        }
        catch (Exception e) {
            throw new ApplicationException("failed to judge solution id : "
                    + solution.getId());
        }
        finally {

            delete(new File(
                    pathHelper
                            .absoluteStagingDirectoryPath(stagingDirectoryPath)));
        }

    }

    private void delete(File file) {

        if (file.exists()) {
            if (file.isDirectory()) {
                for (File nestedFile : file.listFiles()) {
                    delete(nestedFile);
                }

                file.delete();
            }
            else {
                file.delete();
            }
        }

    }

    public abstract String sourceFileName();

    public abstract String executableFileName();

    /**
     * Compile the given source file
     * 
     * @author anandm
     * @param sourceFile
     * @return empty string if compilation was successful else returns
     *         compilation errors
     */
    public abstract String compile(String stagingDirectoryPath);

    public abstract EvaluationResultStatus test(String stagingDirectoryPath,
                                                TestCase testCase,
                                                long timeLimit,
                                                long memoryLimit);
}
