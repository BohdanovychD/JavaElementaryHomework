package lesson_28.functionalInterface;

@FunctionalInterface
public interface FunctionInterface<T, R> {

    R numberToString(T t);
}
