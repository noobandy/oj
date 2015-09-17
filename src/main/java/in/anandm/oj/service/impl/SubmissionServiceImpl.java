package in.anandm.oj.service.impl;

import in.anandm.oj.command.SolutionSubmissionCommand;
import in.anandm.oj.model.EmailId;
import in.anandm.oj.model.Judge;
import in.anandm.oj.model.Language;
import in.anandm.oj.model.Problem;
import in.anandm.oj.model.Solution;
import in.anandm.oj.model.User;
import in.anandm.oj.repository.ProblemRepository;
import in.anandm.oj.repository.SolutionRepository;
import in.anandm.oj.repository.UserRepository;
import in.anandm.oj.service.SolutionUploadHelper;
import in.anandm.oj.service.SubmissionService;

import java.util.Date;
import java.util.Map;

public class SubmissionServiceImpl implements SubmissionService {

    private SolutionUploadHelper solutionUploadHelper;

    private UserRepository userRepository;

    private ProblemRepository problemRepository;

    private SolutionRepository solutionRepository;

    private Map<Language, Judge> judges;

    /**
     * @param solutionUploadHelper
     * @param userRepository
     * @param problemRepository
     * @param solutionRepository
     */
    public SubmissionServiceImpl(SolutionUploadHelper solutionUploadHelper,
            UserRepository userRepository,
            ProblemRepository problemRepository,
            SolutionRepository solutionRepository) {
        super();
        this.solutionUploadHelper = solutionUploadHelper;
        this.userRepository = userRepository;
        this.problemRepository = problemRepository;
        this.solutionRepository = solutionRepository;
    }

    public Map<Language, Judge> getJudges() {
        return judges;
    }

    public void setJudges(Map<Language, Judge> judges) {
        this.judges = judges;
    }

    @Override
    public Solution submitSolution(SolutionSubmissionCommand command) {
        String solutionFilePath = null;
        if (command.getSolution() != null
                && "".equals(command.getSolution().trim())) {
            solutionFilePath = solutionUploadHelper.uploadSolution(command
                    .getSolution());
        }
        else {
            solutionFilePath = solutionUploadHelper.uploadSolution(command
                    .getSolutionFile());
        }

        Problem problem = problemRepository.getProblem(command.getProblemId());
        User user = userRepository.getUserByEmailId(EmailId
                .createEmailId(command.getUsername()));

        Solution solution = new Solution();
        solution.setAuthor(user);
        solution.setSolutionFilePath(solutionFilePath);
        solution.setSubmittedAt(new Date());

        solution.setProblem(problem);

        solution.setLanguage(command.getLanguage());

        solution = solutionRepository.saveSolution(solution);

        Judge judge = judges.get(command.getLanguage());

        solution = judge.evaluate(solution);

        return solution;
    }
}
