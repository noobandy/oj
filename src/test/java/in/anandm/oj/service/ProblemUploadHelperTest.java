package in.anandm.oj.service;

import static junit.framework.Assert.assertTrue;
import in.anandm.oj.AbstractTest;
import in.anandm.oj.MultiPartFileStub;
import in.anandm.oj.model.Problem;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class ProblemUploadHelperTest extends AbstractTest {

    @Autowired
    private ProblemUploadHelper problemUploadHelper;

    /**
     * Test method for
     * {@link in.anandm.oj.service.ProblemUploadHelper#uploadProblem(org.springframework.web.multipart.MultipartFile)}
     * .
     */
    @Test
    public void testUploadProblem() {
        MultipartFile file = new MultiPartFileStub(
                "C:\\Users\\anandm.MKCLINDIA\\Desktop\\Square.zip");
        Problem problem = problemUploadHelper.uploadProblem(file);

        boolean statementMatches = problem
                .getProblemStatement()
                .equals(
                        "Write a program to calculate square of a given number N."
                                + ""
                                + "Input : first line of input contains no of test cases T."
                                + "then each line contains number N."
                                + ""
                                + "Ouput : each line contains sqare of input N."
                                + "" + "Examle :" + "Input : " + "2" + "3"
                                + "5" + "Output :" + "9" + "25" + ""
                                + "Exlaination: "
                                + "first line 2 (2 test cases)"
                                + "then each input 3 and 5 on seperate line."
                                + "their output " + "3^2 = 9" + "5^2 = 25");

        boolean timeLimitMatches = problem.getMaxTimeLimit() == 1000L;
        boolean memoryLimitMatches = problem.getMaxMemoryLimit() == 1500000000L;
        boolean sourceSizeLimitMatches = problem.getMaxSolutionSizeLimit() == 5000L;

        assertTrue(statementMatches && timeLimitMatches && memoryLimitMatches
                && sourceSizeLimitMatches);
    }
}
