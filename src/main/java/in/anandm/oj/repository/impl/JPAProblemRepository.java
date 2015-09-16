package in.anandm.oj.repository.impl;

import in.anandm.oj.model.Problem;
import in.anandm.oj.repository.ProblemRepository;

public class JPAProblemRepository extends JPABaseRepository<Problem, String>
        implements ProblemRepository {

    @Override
    public Problem saveProblem(Problem problem) {

        return super.save(problem);
    }

    @Override
    public Problem getProblem(String id) {
        return super.find(id);
    }

}
