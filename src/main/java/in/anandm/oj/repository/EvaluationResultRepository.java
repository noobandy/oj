package in.anandm.oj.repository;

import in.anandm.oj.model.EvaluationResult;
import in.anandm.oj.model.Solution;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface EvaluationResultRepository {

    @Transactional
    EvaluationResult saveEvaluationResult(EvaluationResult evaluationResult);

    List<EvaluationResult> getAllEvaluationResultsOfSolution(Solution solution);
}
