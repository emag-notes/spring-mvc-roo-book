package at.morec.springmvcroobook.springmyapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author tanabe
 */
public class MyDataRepositoryImpl implements MyDataRepository<MyData> {

  private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

  public List<MyData> getAll() {
    EntityManager em = getEntityManager();
    TypedQuery<MyData> query = em.createQuery("from MyData", MyData.class);
    List<MyData> list = query.getResultList();
    em.close();
    return list;
  }

  @Override
  public MyData findById(long id) {
    return getEntityManager().createQuery("from MyData where id = :id", MyData.class)
                            .setParameter("id", id).getSingleResult();
  }

  @Override
  public List<MyData> findByName(String name) {
    return getEntityManager().createQuery("from MyData where name = :name", MyData.class)
                            .setParameter("name", name).getResultList();
  }

  @Override
  public void add(MyData myData) {
    EntityManager em = getEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(myData);
    transaction.commit();
    em.close();
  }

  @Override
  public void update(MyData data) {
    EntityManager em = getEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.merge(data);
    transaction.commit();
    em.close();
  }

  @Override
  public void delete(MyData data) {
    EntityManager em = getEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    MyData entity = em.merge(data);
    em.remove(entity);
    transaction.commit();
    em.close();
  }

  @Override
  public void delete(long id) {
    delete(findById(id));
  }

  private static EntityManager getEntityManager() {
    return factory.createEntityManager();
  }

}
