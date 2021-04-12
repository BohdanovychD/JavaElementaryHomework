package lesson_27.interfaces;

public interface FirstInterface {

    default void eat() {
        System.out.println("Eating vegetables");
    }

    static void shout() {
        System.out.println("Shouting");
    }

    void reload();

    void buy();
}
