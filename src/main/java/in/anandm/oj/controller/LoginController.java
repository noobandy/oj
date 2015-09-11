package in.anandm.oj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String changePasswordGet(Model model) {
        return "login/chnagePassword";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePasswordPost(Model model) {
        return "redirect:todo/todos";
    }

}
