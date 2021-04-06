package lesson_22.dao;

import lesson_22.model.Account;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lesson_22.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao {

    Logger logger = Logger.getLogger(AccountDaoImpl.class);

    @Override
    public void save(Account account) {
        logger.debug(String.format("save. account{id=%d, clientId=%d, number=%s, value=%f}, " +
                "account.getId(), account.getClientId(), account.getNumber(), account.getValue()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Account account) {
        logger.debug(String.format("update. account{id=%d, clientId=%d, number=%s, value=%f}, " +
                "account.getId(), account.getClientId(), account.getNumber(), account.getValue()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Account account) {
        logger.debug(String.format("delete. account{id=%d, clientId=%d, number=%s, value=%f}, " +
                "account.getId(), account.getClientId(), account.getNumber(), account.getValue()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
        session.close();
    }

    @Override
    public Account findById(long id) {
        logger.debug(String.format("findById. account{id=%d}, account.getId()"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Account.class).getReference(id);
    }
}
