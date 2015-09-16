package in.anandm.oj.repository;

import in.anandm.oj.model.Problem;

import org.springframework.transaction.annotation.Transactional;

public interface ProblemRepository {

    @Transactional
    Problem saveProblem(Problem problem);

    Problem getProblem(String id);
}
