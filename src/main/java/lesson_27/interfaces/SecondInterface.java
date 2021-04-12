package lesson_27.interfaces;

public interface SecondInterface extends FirstInterface {
    default void eat() {
        System.out.println("Eating main dish");
    }

    static void jump() {
        System.out.println("Jumping");
    }

    void play();

    void drive();
}
