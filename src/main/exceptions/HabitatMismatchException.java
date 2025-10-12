package src.main.exceptions;

public class HabitatMismatchException extends Exception {

    public HabitatMismatchException () {
        super("Cannot add Animal to Habitat");
    }
}