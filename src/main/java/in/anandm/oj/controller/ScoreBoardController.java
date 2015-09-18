package in.anandm.oj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/scoreboard")
public class ScoreBoardController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String submissions() {

        return "scoreboard/index";
    }

}
