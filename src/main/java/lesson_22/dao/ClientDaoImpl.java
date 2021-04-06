package lesson_22.dao;

import lesson_22.model.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lesson_22.util.HibernateUtil;
import org.hibernate.query.Query;

public class ClientDaoImpl implements ClientDao {

    Logger logger = Logger.getLogger(ClientDaoImpl.class);

    @Override
    public void save(Client client) {
        logger.debug(String.format("save. client{id=%d, name=%s, email=%s, about=%s, phone=%d, age=%d}, " +
                "client.getId(), client.getName(), client.getEmail(), client.getAbout(), " +
                "client.getPhone(), client.getAge"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Client client) {
        logger.debug(String.format("update. client{id=%d, name=%s, email=%s, about=%s, phone=%d, age=%d}, " +
                "client.getId(), client.getName(), client.getEmail(), client.getAbout(), " +
                "client.getPhone(), client.getAge"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Client client) {
        logger.debug(String.format("delete. client{id=%d, name=%s, email=%s, about=%s, phone=%d, age=%d}, " +
                "client.getId(), client.getName(), client.getEmail(), client.getAbout(), " +
                "client.getPhone(), client.getAge"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client findById(long id) {
        logger.debug(String.format("findById. client{id=%d}, client.getId()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Client.class).getReference(id);
    }

    @Override
    public Client findByPhone(long phone) {
        logger.debug(String.format("findByPhone. client{phone=%s}, client.getPhone()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return (Client) session.createQuery("FROM model.Client WHERE phone = :phone")
                .setParameter("phone", phone).uniqueResult();
    }
}
