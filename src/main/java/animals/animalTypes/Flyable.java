package src.main.java.animals.animalTypes;

import src.main.java.animals.ZooAnimal;

public interface Flyable {

    // Adding on to the comment on canFly() (read that one first), maybe actually we can make fly() and run() or any other
    // action method in the interfaces increase health as well on top of feeding or we can make an entire happiness meter stat
    // that's separate from feeding/hunger
    public void fly();

    // Checks if the habitat itself is big enough for flying space, maybe we can make it affect health/happiness of animal?
    // I want it to take Habitat as a parameter but AviaryHabitat is not created yet soooo I'll wait
    static boolean canFly(ZooAnimal z) {
        return false;
    }

}
