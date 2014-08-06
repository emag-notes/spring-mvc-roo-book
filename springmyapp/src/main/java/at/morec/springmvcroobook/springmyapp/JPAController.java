package at.morec.springmvcroobook.springmyapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author tanabe
 */
@Controller
public class JPAController {

  private static final String JPA_MESSAGE = "jpaMessage";
  private static final String FIND = "find";

  @RequestMapping(value = "/jpa", method = RequestMethod.GET)
  public String jpa(Model model) {
    model.addAttribute("title", "JPA Sample");
    model.addAttribute("message", "JPA のサンプルです");

    MyData myData = new MyData();
    model.addAttribute("myData", myData);

    MyDataRepository<MyData> myDataRepository = new MyDataRepositoryImpl();
    model.addAttribute("dataList", myDataRepository.getAll());

    return JPA_MESSAGE;
  }

  @RequestMapping(value = "/jpa", method = RequestMethod.POST)
  public String form(@Valid @ModelAttribute MyData myData, Errors result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("title", "JPA Sample[ERROR]");
      model.addAttribute("message", "値を再チェックしてください");
      return JPA_MESSAGE;
    }

    MyDataRepository<MyData> myDataRepository = new MyDataRepositoryImpl();
    myDataRepository.add(myData);
    return "redirect:/jpa";
  }

  @RequestMapping(value = "/update", method = RequestMethod.GET)
  public String edit(@RequestParam("id") int id, Model model) {
    model.addAttribute("title", "JPA Sample[UPDATE]");
    model.addAttribute("message", "更新のページ");
    MyDataRepository<MyData> myDataRepository = new MyDataRepositoryImpl();
    MyData myData = myDataRepository.findById(id);
    model.addAttribute("myData", myData);
    model.addAttribute("dataList", myDataRepository.getAll());
    return JPA_MESSAGE;
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(@Valid @RequestParam("id") int id, @ModelAttribute MyData myData, Errors result, Model model) {
    MyDataRepository<MyData> myDataRepository = new MyDataRepositoryImpl();
    myDataRepository.update(myData);
    return "redirect:/jpa";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String delete(@RequestParam("id") int id, Model model) {
    MyDataRepository<MyData> myDataRepository = new MyDataRepositoryImpl();
    myDataRepository.delete(id);
    return "redirect:/jpa";
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public String find(Model model) {
    model.addAttribute("title", "JPA Sample[SEARCH]");
    model.addAttribute("message", "検索のページ");

    MyDataRepository<MyData> myDataRepository = new MyDataRepositoryImpl();
    model.addAttribute("dataList", myDataRepository.getAll());

    return FIND;
  }

  @RequestMapping(value = "/find", method = RequestMethod.POST)
  public String search(HttpServletRequest request, Model model) {
    String fstr = request.getParameter("fstr");
    model.addAttribute("title", "JPA Sample[SEARCH RESULT]");
    model.addAttribute("message", fstr + " の検索結果");

    MyDataRepository<MyData> myDataRepository = new MyDataRepositoryImpl();
    model.addAttribute("dataList", myDataRepository.find(fstr));
    return FIND;
  }

}
