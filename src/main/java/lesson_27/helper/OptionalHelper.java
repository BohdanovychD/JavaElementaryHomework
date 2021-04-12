package lesson_27.helper;

import java.util.Optional;

public class OptionalHelper {

    public static Optional checkEmail(String email) {
        if (email == null || email.isBlank() ||
                email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
            return Optional.empty();
        }
        return Optional.of(email);
    }
}
