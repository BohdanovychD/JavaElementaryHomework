import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Object> empty = Stream.empty();
        empty.skip(1)
                .distinct()
                .findAny();

        System.out.print("Second task data: ");
        List<String> firstList = List.of("one", "two", "three", "something");
        firstList.stream()
                .filter(val -> val.length() > 3)
                .limit(1)
                .forEach(System.out::println);

        System.out.print("Third task data: ");
        Stream<String> firstStream = Stream.of("some ", "thing ", "right ", "here ");
        List<String> secondList = firstStream.collect(Collectors.toList());
        secondList.forEach(System.out::print);

        System.out.print("\nFourth task data: ");
        Map<Integer, String> firstHashMap = new HashMap<>();
        firstHashMap.put(1, "spoon");
        firstHashMap.put(2, "pencil");
        firstHashMap.put(3, "pen");
        firstHashMap.put(4, "table");
        firstHashMap.put(5, "mouse");
        List<Integer> entriesStream = firstHashMap.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(entriesStream);

        System.out.print("Fifth task data: ");
        List<String> linkedList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            linkedList.add(String.valueOf(i));
        }
        Stream<String> secondStream = linkedList.stream();
        Set firstSet = secondStream
                .skip(1)
                .limit(8)
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(firstSet);

        System.out.print("Sixth task data: ");
        Stream<String> thirdStream = Stream.of("book", "page", "phone", "printer");
        System.out.println(thirdStream.parallel()
                .filter(e -> e.length() > 4)
                .skip(1)
                .findFirst());

        System.out.print("Seventh task data: ");
        Stream<String> fourthStream = Stream.of("calculator", "bottle", "work", "paper");
        fourthStream.filter(word -> word.length() > 3).map(word -> {
            System.out.println("Word in lower case:");
            return word.toLowerCase();
        }).forEach(word -> System.out.println("for each: "));
    }
}
