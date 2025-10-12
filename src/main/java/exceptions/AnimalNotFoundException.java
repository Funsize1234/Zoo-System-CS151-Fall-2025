package src.main.java.exceptions;

public class AnimalNotFoundException extends Exception {
    public AnimalNotFoundException() {
        super("Animal not found");
    }
}
