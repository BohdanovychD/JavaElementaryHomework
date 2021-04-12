package lesson_28.functionalInterface;

@FunctionalInterface
public interface SupplierInterface<T> {

    T get();
}
