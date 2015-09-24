package in.anandm.oj.controller;

import in.anandm.oj.service.ProblemUploadHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
@RequestMapping(value = "/problem")
public class ProblemController extends BaseController {

    @Autowired
    private ProblemUploadHelper problemUploadHelper;

    @RequestMapping(method = RequestMethod.GET)
    public String problems() {

        return "problem/index";
    }

    @RequestMapping(value = "/{problemCode}", method = RequestMethod.GET)
    public String problem(Model model,
                          @PathVariable(value = "problemCode") String problemCode) {

        return "problem/problem";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddProblemFrom() {

        return "problem/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAddProblemFrom(MultipartRequest request) {
        List<MultipartFile> problems = request.getMultiFileMap()
                .get("problems");
        if (problems != null && !problems.isEmpty()) {
            for (MultipartFile file : problems) {
                problemUploadHelper.uploadProblem(file);
            }
        }
        return "redirect:list";
    }

}
