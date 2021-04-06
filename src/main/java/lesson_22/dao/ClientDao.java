package lesson_22.dao;

import lesson_22.model.Client;

public interface ClientDao {
    void save(Client client);

    void update(Client client);

    void delete(Client client);

    Client findById(long id);

    Client findByPhone(long phone);
}
