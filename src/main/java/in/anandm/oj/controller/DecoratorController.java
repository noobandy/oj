/**
 * @filenameName:in.anandm.todo.controller.DecoratorController.java
 * @description:TODO
 * @author anandm
 * @date Aug 14, 2015 11:45:05 AM
 * @version: TODO
 */
package in.anandm.oj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className:in.anandm.todo.controller.DecoratorController.java
 * @description:TODO
 * @author anandm
 * @date Aug 14, 2015 11:45:05 AM
 */
@Controller
@RequestMapping(value = "/decorators")
public class DecoratorController extends BaseController {

    @RequestMapping(value = "{decorator}")
    public String decorator(@PathVariable(value = "decorator") String decorator) {
        return "decorators/" + decorator;
    }
}
