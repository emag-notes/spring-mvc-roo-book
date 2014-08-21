package at.morec.springmvcroobook.myrooapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
  public String index() {
    return "hello/index";
  }

}
