package lesson_28.functionalInterface;

@FunctionalInterface
public interface PredicateInterface<T> {

    boolean value(T t);
}
