package at.morec.springmvcroobook.springmyapp;

import java.util.List;

/**
 * @author tanabe
 */
public interface MessageDataDAO<T> {

  List<T> getAll();
  T findById(long id);
  void add(T data);
  void update(T data);
  void delete(T data);
  void delete(long id);

}
