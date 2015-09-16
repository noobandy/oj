package in.anandm.oj.repository;

import in.anandm.oj.model.Problem;
import in.anandm.oj.model.TestCase;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface TestCaseRepository {

    @Transactional
    TestCase saveTestCase(TestCase testCase);

    List<TestCase> getAllTestCasesOfProblem(Problem problem);
}
