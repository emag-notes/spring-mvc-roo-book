package at.morec.springmvcroobook.springmyapp;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author tanabe
 */
@NamedQuery(
  name = "find",
  query = "from MyData where id = :fid or name like :fname or mail like :fmail"
)
@Entity
@Table(name = "mydata")
public class MyData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(length = 50, nullable = false)
  @NotEmpty
  private String name;

  @Column(length = 200, nullable = true)
  @Email
  private String mail;

  @Column(nullable = true)
  @Min(0)
  private int age;

  @Column(nullable = true)
  private String memo;

  @OneToMany(cascade = CascadeType.ALL)
  @Column(nullable = true)
  private List<MessageData> messageDataList;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public List<MessageData> getMessageDataList() {
    return messageDataList;
  }

  public void setMessageDataList(List<MessageData> messageDataList) {
    this.messageDataList = messageDataList;
  }

}
