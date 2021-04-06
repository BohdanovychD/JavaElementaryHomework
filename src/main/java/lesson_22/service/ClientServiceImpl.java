package lesson_22.service;

import lesson_22.dao.ClientDao;
import lesson_22.dao.ClientDaoImpl;
import lesson_22.model.Client;
import org.apache.log4j.Logger;

public class ClientServiceImpl implements ClientService {

    Logger logger = Logger.getLogger(ClientDaoImpl.class);

    @Override
    public void save(Client client) {
        logger.debug(client.toString());
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
        logger.debug(client.toString());
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
        logger.debug(client.toString());
        if (client.getEmail().isBlank() || client.getName().isBlank()) {
            return;
        }
        ClientDao clientDao = new ClientDaoImpl();
        client.setId(client.getId());
        clientDao.delete(client);
    }

    @Override
    public Client findById(long id) {
        logger.debug("Information from client.findId");
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.findById(id);
    }
}
