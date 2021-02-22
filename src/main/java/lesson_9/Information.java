import java.util.*;

public class Information {

    List<String> users = new ArrayList<>();
    Set<String> mails = new LinkedHashSet<>();
    Map ratio = new HashMap<String, Set<String>>();

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public Set<String> getMails() {
        return mails;
    }

    public void setMails(Set<String> mails) {
        this.mails = mails;
    }

    public Map getRatio() {
        return ratio;
    }

    public void setRatio(Map ratio) {
        this.ratio = ratio;
    }
}
