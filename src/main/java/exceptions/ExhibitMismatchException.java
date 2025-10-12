package src.main.java.exceptions;

public class ExhibitMismatchException extends Exception {

    public ExhibitMismatchException () {
        super("Cannot add Animal to Habitat");
    }
}