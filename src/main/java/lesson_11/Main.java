package lesson_11;

import entity.Client;
import exception.WrongFieldException;
import exception.WrongSumException;
import service.Transaction;
import util.ClassHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClassHelper classHelper = new ClassHelper();
        Client client = new Client();
        Client client1 = new Client();
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);

        String accIdentify1 = "";
        String accIdentify2 = "";
        double sum = 1001;

        System.out.println("Write an acc identify of sender");
        while (accIdentify1.length() != 10) {
            accIdentify1 = scanner.nextLine();
        }

        System.out.println("Write an acc identify of getter");
        while (accIdentify2.length() != 10) {
            accIdentify2 = scanner.nextLine();

        System.out.println("Write a sum of money to send");
        while (sum > 1000.0) {
            sum = Double.parseDouble(scanner.nextLine());
        }

        try {
            classHelper.wrongField(accIdentify1);
        } catch (WrongFieldException e) {
            e.printStackTrace();
        }

        try {
            classHelper.wrongField(accIdentify2);
        } catch (WrongFieldException e) {
            e.printStackTrace();
        }

        try {
            classHelper.wrongSum(sum);
        } catch (WrongSumException e) {
            e.printStackTrace();
        }

        transaction.sendMoney(accIdentify1, accIdentify2);
        }
    }
}
