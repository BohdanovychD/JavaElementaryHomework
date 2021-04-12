package lesson_28;

import lesson_28.functionalInterface.ConsumerInterface;
import lesson_28.functionalInterface.FunctionInterface;
import lesson_28.functionalInterface.PredicateInterface;
import lesson_28.functionalInterface.SupplierInterface;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PredicateInterface<Double> doublePredicateInterface = money -> money >= 1500;
        System.out.println("Predicate example: " + doublePredicateInterface.value(1600.0));

        System.out.print("Consumer example: ");
        ConsumerInterface<String> stringConsumerInterface = string -> {
          char[] arraySymbols = string.toCharArray();
            for (int i = 0; i < arraySymbols.length; i++) {
                System.out.print(arraySymbols[i] + " ");
            }
        };
        stringConsumerInterface.stringToArray("SomeText");

        FunctionInterface<Integer, String> integerStringFunctionInterface = number -> {
          switch (number) {
              case 1: return "one";
              case 2: return "two";
              case 3: return "three";
              case 4: return "four";
              case 5: return "five";
              case 6: return "six";
              case 7: return "seven";
              case 8: return "eight";
              case 9: return "nine";
              case 10: return "ten";
          }
          return "unknown";
        };
        System.out.println("\n" + "Function example: " + integerStringFunctionInterface.numberToString(3));

        SupplierInterface<Integer> integerSupplierInterface = () -> 365 / new Random().nextInt(100);
        System.out.println("Supplier example: " + integerSupplierInterface.get());
    }
}
