package lesson_22.service;

import lesson_22.dao.ClientDao;
import lesson_22.dao.ClientDaoImpl;
import lesson_22.model.Client;

public class ClientServiceImpl implements ClientService {
    @Override
    public void save(Client client) {
        ClientDao clientDao = new ClientDaoImpl();

        if (client.getEmail().isBlank() || client.getName().isBlank()) {
            return;
        }
        client.setName(client.getName());
        client.setEmail(client.getEmail());
        client.setAbout(client.getAbout());
        client.setPhone(client.getPhone());

        clientDao.save(client);
    }

    @Override
    public void update(Client client) {
        ClientDao clientDao = new ClientDaoImpl();

        if (client.getEmail().isBlank() || client.getName().isBlank()) {
            return;
        }
        client.setId(client.getId());
        client.setName(client.getName());
        client.setEmail(client.getEmail());
        client.setAbout(client.getAbout());
        client.setPhone(client.getPhone());

        clientDao.update(client);

    }

    @Override
    public void delete(Client client) {
        if (client.getEmail().isBlank() || client.getName().isBlank()) {
            return;
        }
        ClientDao clientDao = new ClientDaoImpl();
        client.setId(client.getId());
        clientDao.delete(client);
    }

    @Override
    public Client findById(long id) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.findById(id);
    }
}
