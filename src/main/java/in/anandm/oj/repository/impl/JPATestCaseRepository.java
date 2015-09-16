package in.anandm.oj.repository.impl;

import in.anandm.oj.model.Problem;
import in.anandm.oj.model.TestCase;
import in.anandm.oj.repository.TestCaseRepository;

import java.util.List;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

public class JPATestCaseRepository extends JPABaseRepository<TestCase, String>
        implements TestCaseRepository {

    @Override
    public TestCase saveTestCase(TestCase testCase) {

        return super.save(testCase);
    }

    @Override
    public List<TestCase> getAllTestCasesOfProblem(Problem problem) {

        Search search = new Search(TestCase.class);
        search.addFilter(Filter.some(
                "problem", Filter.equal("id", problem.getId())));
        return super.search(search);
    }

}
