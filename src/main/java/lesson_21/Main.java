package lesson_21;

import lesson_21.entity.Account;
import lesson_21.entity.Client;
import lesson_21.entity.Status;
import lesson_21.service.AccountService;
import lesson_21.service.ClientService;
import lesson_21.service.StatusService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        AccountService accountService = new AccountService();
        StatusService statusService  = new StatusService();

        // realization for Client
        Client client = new Client();

        client.setName("Maks");
        client.setEmail("maks45y42531@gmail.com");
        client.setAbout("Something about this boy");
        client.setAge(19);
        client.setPhone(380507889877L);
        clientService.save(client);

        List<Client> clients = clientService.getAll();
        System.out.println(clients);

        client.setName("Valeria");
        client.setEmail("valeria25314134g@gmail.com");
        client.setAbout("Something about this girl");
        client.setAge(24);
        client.setPhone(380647589811L);
        clientService.update(client, 18);

        clientService.delete( 16);

//           realization for Account
        Account account = new Account();

        account.setValue(4024.1);
        account.setNumber("UA394815914958104852");
        account.setClientId(11);
        accountService.save(account);

        List<Account> accounts = accountService.getAll();
        System.out.println(accounts);

        account.setClientId(12);
        account.setNumber("RU394815914958104852");
        account.setValue(4444.1);
        accountService.update(account, 22);

        accountService.delete(22);


//        realization for Status
        Status status = new Status();

        List<Status> statuses = statusService.getAll();
        System.out.println(statuses);

        status.setDescription("Ultimate opportunities");
        status.setAlias("ULTIMATE");
        statusService.save(status);

        status.setDescription("No so good");
        status.setAlias("CHEAT");
        statusService.update(status, 4);

        statusService.delete(4);

        clientService.phoneSearch(380504531157L);

        accountService.numberByValue(1000);

        clientService.clientsFromAccount();

        clientService.clientsFromTwoTables();



    }
}
