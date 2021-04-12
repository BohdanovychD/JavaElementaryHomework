package lesson_27.interfaces;

public interface ThirdInterface {
    default void eat() {
        System.out.println("Eating salad");
    }

    static void drink() {
        System.out.println("Don't drink");
    }

    void run();

    void stop();
}
