package src.main.java.exceptions;

public class CapacityExceededException extends Exception {

    public CapacityExceededException(int capacity) {
        super("Capacity Exceeded: Max " + capacity + " can be stored");
    }
    
}
