package code.overcomplicatedobject;

public class AnimalSound {
    private Sound sound;

    public AnimalSound(Sound sound) {
        this.sound = sound;
    }

    public void makeSound() {
        sound.makeSound();
    }

    public static void main(String[] args) {
        AnimalSound dog = new AnimalSound(new BarkingSound());
        dog.makeSound();

        AnimalSound cat = new AnimalSound(new MeowingSound());
        cat.makeSound();
    }
}

interface Sound {
    void makeSound();
}

class BarkingSound implements Sound {
    @Override
    public void makeSound() {
        System.out.println("Barking...");
    }
}

class MeowingSound implements Sound {
    @Override
    public void makeSound() {
        System.out.println("Meowing...");
    }
}