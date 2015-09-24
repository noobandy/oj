package in.anandm.oj.controller;

import in.anandm.oj.command.SolutionSubmissionCommand;
import in.anandm.oj.service.SubmissionService;
import in.anandm.oj.validator.SolutionSubmissionCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/problem/{problemCode}/submission")
public class SubmissionController extends BaseController {

    @Autowired
    private SolutionSubmissionCommandValidator solutionSubmissionCommandValidator;

    @Autowired
    private SubmissionService submissionService;

    @RequestMapping(method = RequestMethod.GET)
    public String submissions(Model model,
                              @PathVariable(value = "problemCode") String problemCode) {

        return "submission/index";
    }

    @RequestMapping(value = "/{submissionId}", method = RequestMethod.GET)
    public String getSubmission(Model model, @PathVariable(
            value = "problemCode") String problemCode, @PathVariable(
            value = "submissionId") String submissionId) {

        return "submission/submission";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getSubmissionFrom(Model model, @PathVariable(
            value = "problemCode") String problemCode) {
        SolutionSubmissionCommand command = new SolutionSubmissionCommand();
        model.addAttribute("command", command);

        return "submission/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postSubmissionFrom(Model model,
                                     @PathVariable(value = "problemCode") String problemCode,
                                     @ModelAttribute(value = "command") SolutionSubmissionCommand command,
                                     BindingResult errors) {
        // validate command

        solutionSubmissionCommandValidator.validate(command, errors);

        if (errors.hasErrors()) {
            model.addAttribute("command", command);
            return "submission/add";
        }

        submissionService.submitSolution(command);

        return "redirect:list";
    }

}
