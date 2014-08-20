package at.morec.springmvcroobook.springmyapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author tanabe
 */
public class MyDataDAOImpl implements MyDataDAO<MyData> {

  private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

  public List<MyData> getAll() {
    EntityManager em = getEntityManager();

    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
    Root<MyData> root = query.from(MyData.class);

    query.select(root).orderBy(builder.asc(root.get("name")));

    return em.createQuery(query)
//              .setFirstResult(5)
//              .setMaxResults(5)
              .getResultList();
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

  @Override
  public List<MyData> find(String fstr) {
    Long fid = 0L;
    try {
      fid = Long.parseLong(fstr);
    } catch (NumberFormatException e) {}

    EntityManager em = getEntityManager();
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
    Root<MyData> root = query.from(MyData.class);

    query
      .select(root)
      .where(builder.equal(root.get("name"), fstr));

    return em.createQuery(query).getResultList();
  }

  private static EntityManager getEntityManager() {
    return factory.createEntityManager();
  }

}
