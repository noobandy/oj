package in.anandm.oj.controller;

import in.anandm.oj.command.RegistrationCommand;
import in.anandm.oj.service.UserService;
import in.anandm.oj.validator.RegistrationCommandValidator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {

    @Autowired
    private RegistrationCommandValidator registrationCommandValidator;

    @Autowired
    private UserService userService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        if (isAuthenticated()) {
            return "redirect:/problem";
        }
        RegistrationCommand registrationCommand = new RegistrationCommand();
        model.addAttribute("registrationCommand", registrationCommand);

        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute(value = "registrationCommand") RegistrationCommand registrationCommand,
                           BindingResult errors,
                           Model model,
                           Locale locale,
                           RedirectAttributes redirectAttributes) {
        registrationCommandValidator.validate(registrationCommand, errors);

        if (errors.hasErrors()) {
            model.addAttribute("registrationCommand", registrationCommand);
            return "home";
        }
        // register user
        userService.registerUser(registrationCommand);

        addAlert(redirectAttributes, Alert.success("Register.User.success"));

        return "redirect:/";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgotPasswordGet(Model model) {
        return "login/forgotPassword";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String forgotPasswordPost(Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String resetPasswordGet(Model model) {
        return "login/resetPassword";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String resetPasswordPost(Model model) {
        return "redirect:/";
    }

}
