package in.anandm.oj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/submission")
public class SubmissionController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String submissions() {

        return "submission/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getSubmissionFrom() {

        return "submission/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postSubmissionFrom() {

        return "redirect:list";
    }

}
