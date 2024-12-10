package code.overcomplicatedobject;

import java.util.List;

public class Animal {
    private List<Behavior> behaviors;

    public Animal(List<Behavior> behaviors) {
        this.behaviors = behaviors;
    }

    public void performBehaviors() {
        for (Behavior behavior : behaviors) {
            behavior.perform();
        }
    }

    public static void main(String[] args) {
        Animal husky = new Animal(List.of(new BarkingBehavior()));
        husky.performBehaviors();
    }
}

interface Behavior {
    void perform();
}

class BarkingBehavior implements Behavior {
    @Override
    public void perform() {
        System.out.println("Barking...");
    }
}