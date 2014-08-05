package at.morec.springmvcroobook.springmyapp;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @author tanabe
 */
public class ValidationFormModel {

  @NotEmpty
  private String item;
  @Min(0)
  private Integer price;
  private Date buydate;
  @Phone(onlyNumber = true)
  private String memo;

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Date getBuydate() {
    return buydate;
  }

  public void setBuydate(Date buydate) {
    this.buydate = buydate;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

}
