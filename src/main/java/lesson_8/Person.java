package lesson_8;

import java.io.FileNotFoundException;

public class Person {

    private String firstName;
    private String secondName;
    private String mail;
    private String password;
    private String role;
    private int age;

    public Person() {
    }

    public Person(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMail() {
        return mail;
    }

    public Object setMail(String mail) {
        this.mail = mail;
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static void main(String[] args) throws FileNotFoundException {

        AdminService adminService = new AdminService();
        UserService userService = new UserService();

        Admin admin = new Admin("ADMIN");
        admin.setMail("admin1@gmail.com");

        User user = new User("USER");
        user.setMail("user1@gmail.com");

        adminService.writeData(admin);
        adminService.writeData(user);
        userService.writeData(user);

        adminService.checkUser(admin);
        userService.checkUser(user);
    }
}

