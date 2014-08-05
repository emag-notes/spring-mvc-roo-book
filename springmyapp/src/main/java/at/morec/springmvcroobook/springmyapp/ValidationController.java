package at.morec.springmvcroobook.springmyapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author tanabe
 */
@Controller
public class ValidationController {

  private static final String VALIDATE_MESSAGE = "validateMessage";

  private List<ValidationFormModel> buyList = new ArrayList<>();

  @RequestMapping(value = "/validation", method = RequestMethod.GET)
  public String validate(Model model) {
    model.addAttribute("title", "Validation Sample");
    model.addAttribute("message", "Validation のサンプルです");
    model.addAttribute("validationFormModel", new ValidationFormModel());
    model.addAttribute("dataList", buyList);
    return VALIDATE_MESSAGE;
  }

  @RequestMapping(value = "/validation", method = RequestMethod.POST)
  public String form(@Valid @ModelAttribute ValidationFormModel formModel, BindingResult result, Model model) {

    if (result.hasErrors()) {
      model.addAttribute("title", "Validation Sample[Error]");
      model.addAttribute("message", "値を再チェックしてください");
    } else {

      buyList.add(formModel);
      model.addAttribute("title", "Validation Sample");

      StringBuilder response = new StringBuilder()
        .append("<ol>")
        .append("<li>").append(formModel.getItem()).append("</li>")
        .append("<li>").append(formModel.getPrice()).append("</li>")
        .append("<li>").append(formModel.getMemo()).append("</li>")
        .append("<li>").append(Calendar.getInstance().getTime()).append("</li>")
        .append("</ol>")
        .append("<p>").append(buyList.size()).append("</p>");

      model.addAttribute("message", response);
      model.addAttribute("validationFormModel", new ValidationFormModel());

    }

    model.addAttribute("dataList", buyList);
    return "validateMessage";

  }

}
