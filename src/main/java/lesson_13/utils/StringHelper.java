package lesson_13.utils;

import exception.StringFormatException;

public class StringHelper {

    public String stringTransformation(String someString, char[] someArr) throws StringFormatException {

        String stringFromArr = null;

        try {
            stringFromArr = new String(someArr);
        } catch (NullPointerException e) {
            System.out.println("Array is empty");
        }

        if (someString.isBlank() && stringFromArr.isBlank()) {
            throw new StringFormatException();
        } else {
            someString = someString.toLowerCase().strip();
            stringFromArr = stringFromArr.toUpperCase().strip();
            String generalString = someString.concat(" ").concat(stringFromArr);
            generalString = generalString.substring(4, 6);
            return generalString;
        }
    }
}
