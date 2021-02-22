package lesson_13.utils;

public class InfoChecker {

    public static boolean ukrPhoneNumberChecker(String phoneNumber) {

            boolean result = phoneNumber.matches("(\\+380)\\d{9}");
            return result;
    }

    public static boolean mailChecker(String mail) {

        boolean result = mail.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        return result;
    }

    public static boolean dataChecker (String data) {

        boolean result = data.matches("\\d{4}-\\d{2}-\\d{2}");
        return result;
    }
}
