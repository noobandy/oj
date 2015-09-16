package in.anandm.oj.repository;

import in.anandm.oj.model.Solution;

import org.springframework.transaction.annotation.Transactional;

public interface SolutionRepository {

    @Transactional
    Solution saveSolution(Solution solution);

    Solution getSolution(String id);
}
