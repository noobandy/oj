package in.anandm.oj.validator;

import in.anandm.oj.command.SolutionSubmissionCommand;

import org.springframework.validation.Errors;

public class SolutionSubmissionCommandValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {

        return SolutionSubmissionCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

}
