package at.morec.springmvcroobook.springmyapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author tanabe
 */
public class MessageDataDAOImpl implements MessageDataDAO<MessageData> {

  private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

  @Override
  public List<MessageData> getAll() {
    EntityManager em = getEntityManager();
    List<MessageData> messageDataList = em.createQuery("from MessageData ", MessageData.class).getResultList();
    em.close();
    return messageDataList;
  }

  @Override
  public MessageData findById(long id) {
    return getEntityManager().find(MessageData.class, id);
  }

  @Override
  public void add(MessageData data) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(data);
    tx.commit();
    em.close();
  }

  @Override
  public void update(MessageData data) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.merge(data);
    tx.commit();
    em.close();
  }

  @Override
  public void delete(MessageData data) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    MessageData entity = em.merge(data);
    em.remove(entity);
    tx.commit();
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
