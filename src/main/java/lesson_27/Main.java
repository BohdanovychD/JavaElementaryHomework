package lesson_27;

import lesson_27.helper.OptionalHelper;
import lesson_27.implement.FirstAndSecondImpl;
import lesson_27.implement.ThirdAndFourthImpl;
import lesson_27.interfaces.FirstInterface;
import lesson_27.interfaces.FourthInterface;
import lesson_27.interfaces.SecondInterface;
import lesson_27.interfaces.ThirdInterface;


public class Main {
    public static void main(String[] args) {
        FirstAndSecondImpl firstAndSecond = new FirstAndSecondImpl();
        ThirdAndFourthImpl thirdAndFourth = new ThirdAndFourthImpl();

        firstAndSecond.buy();
        firstAndSecond.drive();
        firstAndSecond.play();
        firstAndSecond.reload();

        thirdAndFourth.put();
        thirdAndFourth.run();
        thirdAndFourth.stay();
        thirdAndFourth.stop();

        FirstInterface.shout();
        SecondInterface.jump();
        ThirdInterface.drink();
        FourthInterface.kick();

        thirdAndFourth.eat();
        firstAndSecond.eat();

        System.out.println("--------------------------------");

        System.out.println(OptionalHelper.checkEmail("some@mail.ru"));
        System.out.println(OptionalHelper.checkEmail(" "));
    }
}
