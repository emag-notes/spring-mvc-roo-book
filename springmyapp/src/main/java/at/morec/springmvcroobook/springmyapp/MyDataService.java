package at.morec.springmvcroobook.springmyapp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author tanabe
 */
@Service
public class MyDataService {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public List<MyData> getAll() {
    return em.createQuery("from MyData", MyData.class).getResultList();
  }

}
