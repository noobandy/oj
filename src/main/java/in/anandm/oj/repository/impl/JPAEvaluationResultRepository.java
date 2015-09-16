package in.anandm.oj.repository.impl;

import in.anandm.oj.model.EvaluationResult;
import in.anandm.oj.model.Solution;
import in.anandm.oj.repository.EvaluationResultRepository;

import java.util.List;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

public class JPAEvaluationResultRepository extends
        JPABaseRepository<EvaluationResult, String> implements
        EvaluationResultRepository {

    @Override
    public EvaluationResult saveEvaluationResult(EvaluationResult evaluationResult) {

        return super.save(evaluationResult);
    }

    @Override
    public List<EvaluationResult> getAllEvaluationResultsOfSolution(Solution solution) {

        Search search = new Search(EvaluationResult.class);
        search.addFilter(Filter.some(
                "problem", Filter.equal("id", solution.getId())));
        return super.search(search);
    }

}
