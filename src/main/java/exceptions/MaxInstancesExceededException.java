package src.main.java.exceptions;

public class MaxInstancesExceededException extends Exception {

    public MaxInstancesExceededException(String className, int attempted, int maximum) {
        super("Maximum instances exceeded for " + className + ": attempted - " + attempted + " max - " + maximum);
    }

}