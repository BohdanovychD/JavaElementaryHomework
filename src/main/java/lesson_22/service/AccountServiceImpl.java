package lesson_22.service;

import lesson_22.dao.AccountDao;
import lesson_22.dao.AccountDaoImpl;
import lesson_22.model.Account;

public class AccountServiceImpl implements AccountService {
    @Override
    public void save(Account account) {
        AccountDao accountDao = new AccountDaoImpl();

        if(account.getNumber().isBlank()) {
            return;
        }
        account.setClientId(account.getClientId());
        account.setNumber(account.getNumber());
        account.setValue(account.getValue());

        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        AccountDao accountDao = new AccountDaoImpl();

        if(account.getNumber().isBlank()) {
            return;
        }
        account.setClientId(account.getClientId());
        account.setNumber(account.getNumber());
        account.setValue(account.getValue());

        accountDao.update(account);
    }

    @Override
    public void delete(Account account) {
        AccountDao accountDao = new AccountDaoImpl();
        account.setId(account.getId());
        accountDao.delete(account);
    }

    @Override
    public Account findById(long id) {
        AccountDao accountDao = new AccountDaoImpl();;
        return accountDao.findById(id);
    }
}
