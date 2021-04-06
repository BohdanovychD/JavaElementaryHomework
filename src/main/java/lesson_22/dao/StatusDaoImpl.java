package lesson_22.dao;

import lesson_22.model.Status;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lesson_22.util.HibernateUtil;

public class StatusDaoImpl implements StatusDao {

    Logger logger = Logger.getLogger(StatusDaoImpl.class);

    @Override
    public void save(Status status) {
        logger.debug(String.format("save. status{id=%d, alias=%s, description=%s}, " +
                "status.getId(), status.getAlias(), status.getDescription()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(status);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Status status) {
        logger.debug(String.format("update. status{id=%d, alias=%s, description=%s}, " +
                "status.getId(), status.getAlias(), status.getDescription()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(status);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Status status) {
        logger.debug(String.format("delete. status{id=%d, alias=%s, description=%s}, " +
                "status.getId(), status.getAlias(), status.getDescription()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(status);
        transaction.commit();
        session.close();
    }

    @Override
    public Status findById(long id) {
        logger.debug(String.format("findById. status{id=%d}, status.getId()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Status.class).getReference(id);
    }
}
