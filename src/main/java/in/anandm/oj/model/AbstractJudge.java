package in.anandm.oj.model;

import in.anandm.oj.repository.EvaluationResultRepository;
import in.anandm.oj.repository.SolutionRepository;
import in.anandm.oj.repository.TestCaseRepository;
import in.anandm.oj.utils.FileUtils;

import java.io.File;
import java.util.Date;
import java.util.List;

public abstract class AbstractJudge implements Judge {

    private String stagingDirectoryPath;

    private TestCaseRepository testCaseRepository;

    private EvaluationResultRepository evaluationResultRepository;

    private SolutionRepository solutionRepository;

    /**
     * @param testCaseRepository
     * @param evaluationResultRepository
     * @param solutionRepository
     */
    public AbstractJudge(TestCaseRepository testCaseRepository,
            EvaluationResultRepository evaluationResultRepository,
            SolutionRepository solutionRepository) {
        super();
        this.testCaseRepository = testCaseRepository;
        this.evaluationResultRepository = evaluationResultRepository;
        this.solutionRepository = solutionRepository;
    }

    public String getStagingDirectoryPath() {
        return stagingDirectoryPath;
    }

    public void setStagingDirectoryPath(String stagingDirectoryPath) {
        this.stagingDirectoryPath = stagingDirectoryPath;
    }

    @Override
    public EvaluationResultStatus evaluate(String solutionId) {
        try {

            Solution solution = solutionRepository.getSolution(solutionId);

            File stagingArea = new File(stagingDirectoryPath + File.separator
                    + solution.getId());
            // create directory
            stagingArea.createNewFile();

            // copy the solution to staging area

            File source = new File(solution.getSolutionFilePath());

            File destination = new File(stagingDirectoryPath + File.separator
                    + solution.getId() + File.separator + sourceFileName());

            FileUtils.copyFile(source, destination, 1024);

            // compile the solution
            String compilationErrors = compile(stagingArea);

            EvaluationResultStatus resultStatus = EvaluationResultStatus.AC;

            if ("".equals(compilationErrors.trim())) {
                // compiled successfully
                Problem problem = solution.getProblem();

                List<TestCase> testCases = testCaseRepository
                        .getAllTestCasesOfProblem(problem);

                for (TestCase testCase : testCases) {

                    EvaluationResultStatus status = test(stagingArea, testCase);

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
            solution.setStatus(EvaluationResultStatus.CE);
            solution.setCompilationErrors(compilationErrors);

            solutionRepository.saveSolution(solution);

            return resultStatus;
        }
        catch (Exception e) {
            throw new ApplicationException("failed to judge solution id : "
                    + solutionId);
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
    public abstract String compile(File stagingArea);

    public abstract EvaluationResultStatus test(File stagingArea,
                                                TestCase testCase);
}
