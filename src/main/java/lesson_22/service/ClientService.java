package lesson_22.service;

import lesson_22.model.Client;

public interface ClientService {
    void save(Client client);

    void update(Client client);

    void delete(Client client);

    Client findById(long id);
}
