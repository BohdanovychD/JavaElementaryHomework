package lesson_27.implement;

import lesson_27.interfaces.FirstInterface;
import lesson_27.interfaces.SecondInterface;

public class FirstAndSecondImpl implements FirstInterface, SecondInterface {

    @Override
    public void reload() {
        System.out.println("Reload a gun");
    }

    @Override
    public void buy() {
        System.out.println("Buy a gun");
    }

    @Override
    public void play() {
        System.out.println("Play a game");
    }

    @Override
    public void drive() {
        System.out.println("Drive a car");
    }
}
