package in.anandm.oj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/problem")
public class ProblemController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String problems() {

        return "problem/index";
    }

    @RequestMapping(value = "/${problemId}", method = RequestMethod.GET)
    public String problem() {

        return "problem/problem";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddProblemFrom() {

        return "problem/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAddProblemFrom() {

        return "redirect:list";
    }

}
