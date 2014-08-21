package at.morec.springmvcroobook.myrooapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/hello/**")
@Controller
public class HelloController {

  @RequestMapping(method = RequestMethod.POST, value = "{id}")
  public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
  }

  @RequestMapping
  public String index(Model model) {
    model.addAttribute("formData", new FormData());
    return "hello/index";
  }

  @RequestMapping(method = RequestMethod.POST, value = "/form")
  public String post(@ModelAttribute FormData form, Errors result, Model model) {
    model.addAttribute("message", "You typed: " + form.getInput());
    return "hello/index";
  }

}
