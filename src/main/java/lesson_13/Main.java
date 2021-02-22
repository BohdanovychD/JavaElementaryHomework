package lesson_13;

import exception.StringFormatException;
import utils.InfoChecker;
import utils.StringHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[] someArr = {'d', 'i', 'm', 'a'};

        StringHelper sh = new StringHelper();
        try {
            System.out.println(sh.stringTransformation("SomeString", someArr));
            System.out.println("---------------------------------");
        } catch (StringFormatException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a phone number:");
        while (true) {
            if (InfoChecker.ukrPhoneNumberChecker(String.valueOf(scanner.nextLine()))) {
                System.out.println("Correct number");
                break;
            } else {
                System.out.println("Incorrect number. Please, write again");
            }
        }

        System.out.println("Write an email:");
        while (true) {
            if (InfoChecker.mailChecker(String.valueOf(scanner.nextLine()))) {
                System.out.println("Correct mail");
                break;
            } else {
                System.out.println("Incorrect mail. Please, write again");
            }
        }

        System.out.println("Write a data of birth:");
        while (true) {
            if (InfoChecker.dataChecker(String.valueOf(scanner.nextLine()))) {
                System.out.println("Correct data");
                break;
            } else {
                System.out.println("Incorrect data. Please, write again");
            }
        }
    }
}
