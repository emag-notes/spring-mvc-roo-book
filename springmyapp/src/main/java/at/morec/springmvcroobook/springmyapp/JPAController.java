package at.morec.springmvcroobook.springmyapp;

import at.morec.springmvcroobook.springmyapp.repositories.MyDataRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

  @Autowired
  private MyDataService myDataService;

  @Autowired
  private MyDataRepository myDataRepository;

  @InitBinder
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    binder.registerCustomEditor(MyData.class, new MyDataPropertyEditor());
  }

  @RequestMapping(value = "/jpa", method = RequestMethod.GET)
  public String jpa(Model model) {
    model.addAttribute("title", "JPA Sample");
    model.addAttribute("message", "JPA のサンプルです");

    MyData myData = new MyData();
    model.addAttribute("myData", myData);

    model.addAttribute("dataList", myDataRepository.findAll());

    return JPA_MESSAGE;
  }

  @RequestMapping(value = "/jpa", method = RequestMethod.POST)
  public String form(@Valid @ModelAttribute MyData myData, Errors result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("title", "JPA Sample[ERROR]");
      model.addAttribute("message", "値を再チェックしてください");
      return JPA_MESSAGE;
    }

    myDataRepository.saveAndFlush(myData);
    return "redirect:/jpa";
  }

  @RequestMapping(value = "/update", method = RequestMethod.GET)
  public String edit(@RequestParam("id") long id, Model model) {
    model.addAttribute("title", "JPA Sample[UPDATE]");
    model.addAttribute("message", "更新のページ");
    MyData myData = myDataRepository.findById(id);
    model.addAttribute("myData", myData);
    model.addAttribute("dataList", myDataRepository.findAll());
    return JPA_MESSAGE;
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(@Valid @ModelAttribute MyData myData, Errors result, Model model) {
    myDataRepository.saveAndFlush(myData);
    return "redirect:/jpa";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String delete(@RequestParam("id") int id, Model model) {
    MyDataDAO<MyData> myDataDAO = new MyDataDAOImpl();
    myDataDAO.delete(id);
    return "redirect:/jpa";
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public String find(Model model) {
    model.addAttribute("title", "JPA Sample[SEARCH]");
    model.addAttribute("message", "検索のページ");

    MyDataDAO<MyData> myDataDAO = new MyDataDAOImpl();
    model.addAttribute("dataList", myDataDAO.getAll());

    return FIND;
  }

  @RequestMapping(value = "/find", method = RequestMethod.POST)
  public String search(HttpServletRequest request, Model model) {
    String fstr = request.getParameter("fstr");
    model.addAttribute("title", "JPA Sample[SEARCH RESULT]");
    model.addAttribute("message", fstr + " の検索結果");

    MyDataDAO<MyData> myDataDAO = new MyDataDAOImpl();
    model.addAttribute("dataList", myDataDAO.find(fstr));
    return FIND;
  }

  @RequestMapping(value = "/msg", method = RequestMethod.GET)
  public String msg(Model model) {
    model.addAttribute("title", "MessageData Sample");
    model.addAttribute("message", "MessageData のサンプルです。");

    MessageData messageData = new MessageData();
    model.addAttribute("messageData", messageData);

    MessageDataDAO<MessageData> dao = new MessageDataDAOImpl();
    model.addAttribute("datalist", dao.getAll());
    return "showMessageData";
  }

  @RequestMapping(value = "/msg", method = RequestMethod.POST)
  public String msgform(@Valid @ModelAttribute MessageData messageData, Errors result, Model model) {
    System.out.println("msgform: " + messageData.getMyData());
    if (result.hasErrors()) {
      model.addAttribute("title", "MessageData Sample[ERROR]");
      model.addAttribute("message", "値を再チェックしてください!");
      return "showMessageData";
    }
    MessageDataDAO<MessageData> dao = new MessageDataDAOImpl();
    dao.add(messageData);
    return "redirect:/msg";
  }
}
