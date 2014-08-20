package at.morec.springmvcroobook.springmyapp.repositories;

import at.morec.springmvcroobook.springmyapp.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tanabe
 */
@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

  MyData findById(long id);
  List<MyData> findByNameLike(String name);
  List<MyData> findByIdIsNotNullOrderByIdDesc();
  List<MyData> findByAgeGreaterThan(Integer age);
  List<MyData> findByAgeBetween(Integer age1, Integer age2);

}
