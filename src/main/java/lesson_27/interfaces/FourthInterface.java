package lesson_27.interfaces;

public interface FourthInterface extends ThirdInterface {

    default void eat() {
        System.out.println("Eating fruits");
    }

    static void kick() {
        System.out.println("Kick up something");
    }

    void put();

    void stay();
}
