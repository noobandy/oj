package in.anandm.oj.service;

import static org.junit.Assert.assertTrue;
import in.anandm.oj.AbstractTest;
import in.anandm.oj.MultiPartFileStub;
import in.anandm.oj.command.SolutionSubmissionCommand;
import in.anandm.oj.model.EvaluationResultStatus;
import in.anandm.oj.model.Language;
import in.anandm.oj.model.Solution;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SubmissionServiceTest extends AbstractTest {

    @Autowired
    private SubmissionService submissionService;

    @Test
    public void testSubmitSolution() {
        SolutionSubmissionCommand command = new SolutionSubmissionCommand();
        command.setProblemId("402894484fdb1c0c014fdb1c0f1e0000");
        command.setLanguage(Language.JAVA);
        command.setUsername("anandm@mkcl.org");
        command.setSolutionFile(new MultiPartFileStub(
                "E:\\WorkData\\workspace\\online-judge\\src\\test\\java\\Main.java"));

        Solution solution = submissionService.submitSolution(command);

        assertTrue(solution.getStatus() == EvaluationResultStatus.AC);
    }

}
