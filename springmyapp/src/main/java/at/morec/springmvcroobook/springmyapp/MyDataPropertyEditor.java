package at.morec.springmvcroobook.springmyapp;

import java.beans.PropertyEditorSupport;

/**
 * @author tanabe
 */
public class MyDataPropertyEditor extends PropertyEditorSupport {

  @Override
  public String getAsText() {
    MyData value = (MyData) getValue();
    System.out.println("getAsText: " + value);
    if (value == null) {
      return "";
    } else {
      return String.valueOf(value.getId());
    }
  }

  @Override
  public void setAsText(String value) {
    MyDataDAO<MyData> dao = new MyDataDAOImpl();
    MyData myData = dao.findById(Long.parseLong(value));
    System.out.println("setAsText: " + myData);
    setValue(myData);
  }

}
