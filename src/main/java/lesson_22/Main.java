package lesson_22;

import lesson_22.model.Account;
import lesson_22.model.Client;
import lesson_22.model.Status;
import lesson_22.service.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.DEBUG, "Something");

        Client client = new Client();
        ClientService clientService = new ClientServiceImpl();

        Account account = new Account();
        AccountService accountService = new AccountServiceImpl();

        Status status = new Status();
        StatusService statusService = new StatusServiceImpl();

        client.setPhone(380677196071L);
        client.setAbout("Kind and friendly");
        client.setEmail("alina2342@gmail.com");
        client.setName("Alina");
        client.setAge(22);
        clientService.save(client);

//        client.setId(4);
//        client.setName("Valera");
//        client.setEmail("valera342@gmail");
//        client.setPhone(380971303947L);
//        client.setAbout("gwetggaeg");
//        clientService.update(client);

//        clientService.delete(4);

//        System.out.println(clientDao.findById(1));

//        System.out.println(clientDao.findByPhone(380647512348L));


//        status.setAlias("rtjrtj");
//        status.setDescription("trjrjr");
//        statusService.save(status);

//        status.setId(3);
//        status.setAlias("egEgs");
//        status.setDescription("segsegege");
//        statusService.update(status);


//        statusService.delete(3);

//        System.out.println(statusDao.findById(2));

//        account.setClientId(5);
//        account.setNumber("123456786345679");
//        account.setValue(654);
//        accountDao.save(account);

//        account.setId(6);
//        account.setClientId(5);
//        account.setNumber("123456786845679");
//        account.setValue(655);
//        accountDao.update(account);

//        accountDao.delete(6);

//        System.out.println(accountDao.findById(4));


    }
}
