package src.main.java.exceptions;

import src.main.java.animals.ZooAnimal;

public class AnimalNotFoundException extends Exception {
    public AnimalNotFoundException(ZooAnimal animal) {
        super("Animal " + animal.getName() + " not found");
    }
}
