package lesson_8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class UserService implements Service {

    @Override
    public boolean checkUser(Person user) throws FileNotFoundException {

        FileReader fr = new FileReader("Data.txt");

        Scanner scanner = new Scanner(fr);

        boolean something = false;

        while (scanner.hasNextLine()) {
            if (scanner.nextLine().equals(user.getMail())) {
                System.out.println("User is found");
                something = true;
            }
        }
        scanner.close();
        return something;
    }

    @Override
    public void writeData(Person admin) throws FileNotFoundException {
        System.out.println("User cannot write a data");
    }
}
