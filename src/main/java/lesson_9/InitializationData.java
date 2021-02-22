package lesson_9;

public class InitializationData {

    public Information initialization() {

        Information information = new Information();

        for (int i = 0; i < 30; i++) {
            information.users.add("uniquePseudonym" + i);
            information.mails.add("uniqueMail" + i);
            information.ratio.put("uniqueMail" + i, "uniqueMap" + i);
        }

        for (int i = 0; i < 10; i++) {
            information.users.add("sameObject" + i);
            information.mails.add("sameObject" + i);
            information.ratio.put("sameObject" + i, "sameObject" + i);
        }
        return information;
    }
}

