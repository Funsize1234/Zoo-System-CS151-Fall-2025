package src.main.java.exceptions;

import src.main.java.animals.ZooAnimal;
import src.main.java.zoo.Exhibit;

public class ExhibitMismatchException extends Exception {

    public ExhibitMismatchException (ZooAnimal animal, Exhibit exhibit) {
        super("Failed to add Animal of type " + animal.getClass().getSimpleName() + " to Exhibit of type (" + exhibit.getHabitats() + ")");
    }
}