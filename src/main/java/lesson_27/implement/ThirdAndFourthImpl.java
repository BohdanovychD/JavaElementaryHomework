package lesson_27.implement;

import lesson_27.interfaces.FourthInterface;
import lesson_27.interfaces.ThirdInterface;

public class ThirdAndFourthImpl implements ThirdInterface, FourthInterface {

    @Override
    public void run() {
        System.out.println("I'm running anywhere");
    }

    @Override
    public void stop() {
        System.out.println("Stop running");
    }

    @Override
    public void put() {
        System.out.println("Put something up");
    }

    @Override
    public void stay() {
        System.out.println("Stay for a while");
    }
}
