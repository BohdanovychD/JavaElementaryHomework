package lesson_22.dao;

import lesson_22.model.Account;

public interface AccountDao {
    void save(Account account);

    void update(Account account);

    void delete(Account account);

    Account findById(long id);
}
