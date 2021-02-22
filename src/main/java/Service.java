package Homework8;

import java.io.FileNotFoundException;

public interface Service {

    boolean checkUser(Person person) throws FileNotFoundException;
    void writeData(Person person) throws FileNotFoundException;
}
