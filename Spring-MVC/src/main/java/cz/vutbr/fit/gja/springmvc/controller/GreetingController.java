package cz.vutbr.fit.gja.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Martin Kocour
 * created on 23/12/2018
 *
 * Simple controller to display i.e. Hello World!
 */
@Controller
public class GreetingController {

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
