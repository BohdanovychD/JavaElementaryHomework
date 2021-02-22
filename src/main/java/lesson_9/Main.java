import java.util.ArrayList;
import java.util.List;

public class Main {

    void reworkedInformation(List<? extends Number> intNumber, Information information) {

        for (int i = 0; i < intNumber.size(); i++) {
            information.getUsers().add("uniquePseudonym" + String.valueOf(intNumber.get(i)));
        }

        for (int i = 0; i < intNumber.size(); i++) {
            if (!information.mails.contains(("uniqueMail" + intNumber.get(i) + "@gmail.com"))) {
                information.getMails().add(("uniqueMail" + intNumber.get(i)) + "@gmail.com");
            }
        }

        for (int i = 0; i < intNumber.size(); i++) {
            information.getRatio().put("uniquePseudonym" + intNumber.get(i), "uniqueMail" + i + "@gmail.com");
        }

        System.out.println(information.users);
        System.out.println(information.mails);
        System.out.println(information.ratio);
    }

    public static void main(String[] args) {

        InitializationData initializationData = new InitializationData();
        Information initialization = initializationData.initialization();

        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            integerList.add(83 % i);
        }

        Main main = new Main();
        main.reworkedInformation(integerList, initialization);


    }
}


