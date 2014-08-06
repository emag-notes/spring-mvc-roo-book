package at.morec.springmvcroobook.springmyapp;

import java.util.List;

/**
 * @author tanabe
 */
public interface MyDataRepository <T> {

  List<T> getAll();
  T findById(long id);
  List<T> findByName(String name);
  void add(T data);
  void update(T data);
  void delete(T data);
  void delete(long id);

}
