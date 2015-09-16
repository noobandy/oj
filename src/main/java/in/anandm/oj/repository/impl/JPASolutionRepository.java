package in.anandm.oj.repository.impl;

import in.anandm.oj.model.Solution;
import in.anandm.oj.repository.SolutionRepository;

public class JPASolutionRepository extends JPABaseRepository<Solution, String>
        implements SolutionRepository {

    @Override
    public Solution saveSolution(Solution solution) {

        return super.save(solution);
    }

    @Override
    public Solution getSolution(String id) {

        return super.find(id);
    }

}
