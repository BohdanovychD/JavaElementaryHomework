package lesson_11.service;

import entity.Client;
import util.ClassHelper;

public class Transaction {

    Client client = new Client();

    public void sendMoney(String getter, String setter) {
        Client client = new Client();
        ClassHelper classHelper = new ClassHelper();
        getter = client.getClientIdentify();
        setter = client.getClientIdentify();

        classHelper.wrongUser("same", "same");
    }
}
