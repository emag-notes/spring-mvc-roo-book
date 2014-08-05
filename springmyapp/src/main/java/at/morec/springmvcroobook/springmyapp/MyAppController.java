package at.morec.springmvcroobook.springmyapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    formModel.setCheck1(true);
    formModel.setCheckOSs(new String[]{"Linux"});
    formModel.setCheckNums(new String[]{"Three"});
    formModel.setRadio1("male");
    formModel.setRadioOS("Linux");
    formModel.setSelect1("Linux");

    modelAndView.addObject("formModel", formModel);
    modelAndView.addObject("checkOSItems", getOSList());
    modelAndView.addObject("checkNumItems", getNumListDataModels());
    modelAndView.addObject("radioOSItems", getOSListDataModels());
    modelAndView.addObject("optionList", getOSListDataModels());
    modelAndView.addObject("multiOptionList", getOSListDataModels());

    return modelAndView;
  }

  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  public ModelAndView form(@ModelAttribute FormModel formModel) {
    ModelAndView modelAndView = new ModelAndView("showMessage");
    modelAndView.addObject("title", "ModelAndView sample");

    StringBuilder selectedOSItemsResponse = new StringBuilder();
    for (String selected : formModel.getCheckOSs()) {
      selectedOSItemsResponse.append("<li>").append(selected).append("</li>");
    }

    List<ListDataModel> selectedNumItems = new ArrayList<>();
    StringBuilder selectedNumItemsResponse = new StringBuilder();
    for (String selected : formModel.getCheckNums()) {
      selectedNumItems.add(new ListDataModel(selected, selected));
      selectedNumItemsResponse.append("<li>").append(selected).append("</li>");
    }

    StringBuilder multiOptionListResponse = new StringBuilder();
    for (String selected : formModel.getSelectList()) {
      multiOptionListResponse.append("<li>").append(selected).append("</li>");
    }

    StringBuilder response = new StringBuilder()
            .append("<ul><li>").append(formModel.getInput1())
            .append("</li><li>").append(formModel.getPass1())
            .append("</li><li>").append(formModel.getArea1())
            .append("</li><li>checked: ").append(formModel.isCheck1()).append("</li>")
            .append("<ol>").append(selectedOSItemsResponse).append("</ol>")
            .append("<ol>").append(selectedNumItemsResponse).append("</ol>")
            .append("</li><li>selected: ").append(formModel.getRadio1()).append("</li>")
            .append("</li><li>selected: ").append(formModel.getRadioOS()).append("</li>")
            .append("</li><li>selected: ").append(formModel.getSelect1()).append("</li>")
            .append("<ol>").append(multiOptionListResponse).append("</ol>")
            .append("</ul>");

    modelAndView.addObject("message", response);
    modelAndView.addObject("formModel", formModel);
    modelAndView.addObject("checkOSItems", getOSList());
    modelAndView.addObject("checkNumItems", selectedNumItems);
    modelAndView.addObject("radioOSItems", getOSListDataModels());
    modelAndView.addObject("optionList", getOSListDataModels());
    modelAndView.addObject("multiOptionList", getOSListDataModels());

    return modelAndView;
  }

  private static List<String> getOSList() {
    return Arrays.asList("Mac OS X", "Windows", "Linux");
  }

  private static List<ListDataModel> getNumListDataModels() {
    return Arrays.asList(
      new ListDataModel("いち", "One"),
      new ListDataModel("にぃ", "Two"),
      new ListDataModel("さん", "Three"),
      new ListDataModel("しぃ", "Four"),
      new ListDataModel("ごぉ", "Five"));
  }

  private static List<ListDataModel> getOSListDataModels() {
    return Arrays.asList(
      new ListDataModel("マック", "Mac"),
      new ListDataModel("ウインドウズ", "Windows"),
      new ListDataModel("リナックス", "Linux"),
      new ListDataModel("アイフォン", "iOS"),
      new ListDataModel("アンドロイド", "Android")
    );
  }

}
