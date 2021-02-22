package lesson_11.util;

import entity.Client;
import exception.UserExpectedError;
import exception.WrongFieldException;
import exception.WrongSumException;

public class ClassHelper {

    Client client = new Client();

    public void wrongField(String writeIdentify) throws WrongFieldException {

        client.setClientIdentify(writeIdentify);
        if (writeIdentify.length() != 10) {
            throw new WrongFieldException();
        }
    }

    public void wrongSum(double sum) throws WrongSumException {

        client.setSum(sum);
        if (sum > 1000) {
            throw new WrongSumException();
        }
    }

    public void wrongUser(String sender, String getter) {

        client.setClientAccIdentify(sender);
        client.setClientAccIdentify(getter);
        if (!sender.equals(getter)) {
            throw new UserExpectedError();
            }
        }
}
