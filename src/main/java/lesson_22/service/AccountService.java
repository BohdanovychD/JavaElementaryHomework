package lesson_22.service;

import lesson_22.model.Account;

public interface AccountService {
    void save(Account account);

    void update(Account account);

    void delete(Account account);

    Account findById(long id);
}
