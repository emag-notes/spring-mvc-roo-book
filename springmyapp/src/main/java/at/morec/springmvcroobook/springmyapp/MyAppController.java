package at.morec.springmvcroobook.springmyapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tanabe
 */
@Controller
public class MyAppController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public ModelAndView hello() {
    ModelAndView modelAndView = new ModelAndView("showMessage");
    modelAndView.addObject("title", "ModelAndView sample");
    modelAndView.addObject("message", "これは ModelAndView のテストです。");
    FormModel formModel = new FormModel();
    formModel.setInput1("type here...");
    modelAndView.addObject("formModel", formModel);
    return modelAndView;
  }

  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  public ModelAndView form(@ModelAttribute FormModel formModel) {
    ModelAndView modelAndView = new ModelAndView("showMessage");
    modelAndView.addObject("title", "ModelAndView sample");
    modelAndView.addObject("message", "typed: " + formModel.getInput1());
    modelAndView.addObject("formModel", formModel);
    return modelAndView;
  }

}
