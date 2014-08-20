package at.morec.springmvcroobook.springmyapp;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author tanabe
 */
@Entity
@Table(name = "messagedata")
public class MessageData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;

  @Column(nullable = false)
  @NotEmpty
  private String message;

  @ManyToOne
  private MyData myData;

  public MessageData() {
    this.myData = new MyData();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public MyData getMyData() {
    return myData;
  }

  public void setMyData(MyData myData) {
    this.myData = myData;
  }

}
