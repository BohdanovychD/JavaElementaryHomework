package lesson_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class AdminService implements Service {

    @Override
    public boolean checkUser(Person admin) throws FileNotFoundException {

        FileReader fr = new FileReader("Data.txt");

        Scanner scanner = new Scanner(fr);

        boolean something = false;

        while (scanner.hasNextLine()) {
            if (scanner.nextLine().equals(admin.getMail())) {
                System.out.println("Admin is found");
                something = true;
            }
        }
        scanner.close();
        return something;
    }

    @Override
    public void writeData(Person person) throws FileNotFoundException {

        Person admin = new Person("ADMIN");

        admin.setPassword("2421212");
        admin.setFirstName("Mykola");
        admin.setSecondName("Petrovich");
        admin.setAge(30);
        admin.setMail("admin1@gmail.com");

        File file = new File("Data.txt");

        PrintWriter pw = new PrintWriter(file);

        pw.println("Role:" + admin.getRole());
        pw.println("Age -- " + admin.getAge());
        pw.println("First name -- " + admin.getFirstName());
        pw.println("Second name -- " +admin.getSecondName());
        pw.println("Password -- " +admin.getPassword());
        pw.println("Mail: ");
        pw.println("admin1@gmail.com");

        Person user = new Person("USER");

        user.setPassword("2342151");
        user.setFirstName("Vladislav");
        user.setSecondName("Gah");
        user.setAge(35);
        user.setMail("user1@gmail.com");

        pw.println("Role:" + user.getRole());
        pw.println("Age -- " + user.getAge());
        pw.println("First name -- " + user.getFirstName());
        pw.println("Second name -- " + user.getSecondName());
        pw.println("Password -- " + user.getPassword());
        pw.println("Mail: ");
        pw.println("user1@gmail.com");

        pw.close();
    }
}
