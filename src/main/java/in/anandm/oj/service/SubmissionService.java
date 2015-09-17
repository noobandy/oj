package in.anandm.oj.service;

import in.anandm.oj.command.SolutionSubmissionCommand;
import in.anandm.oj.model.Solution;

public interface SubmissionService {

    Solution submitSolution(SolutionSubmissionCommand command);
}
