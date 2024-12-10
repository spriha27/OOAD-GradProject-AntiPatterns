package code.violationofencapsulation;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<String> members = new ArrayList<>();

    public List<String> getMembers() {
        return new ArrayList<>(members); // Return a copy to prevent external modification
    }

    public void addMember(String member) {
        members.add(member);
    }
}