package in.anandm.oj.validator;

import in.anandm.oj.command.RegistrationCommand;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @className:in.anandm.todo.web.validator.RegistrationCommandValidator.java
 * @description:TODO
 * @author anandm
 * @date Aug 17, 2015 2:37:37 PM
 */
public class RegistrationCommandValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {

        return RegistrationCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "emailId", "NotEmpty.User.emailId");
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "password", "NotEmpty.User.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "repeatPassword", "NotEmpty.User.repeatPassword");

    }

}
