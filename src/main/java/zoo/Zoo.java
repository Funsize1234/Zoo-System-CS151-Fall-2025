package src.main.java.zoo;

public class Zoo {
    private int capacity;
    private int visitors;
    private int balance;

    public Zoo() {
        this.visitors = 0;
        this.balance = 0;
    }

    public Zoo(int capacity, int balance) {
        this.capacity = capacity;
        this.visitors = 0;
        this.balance = balance;
    }

    public void addVisitor() {
        if(visitors < capacity) {
            visitors++;
            System.out.println("Visitor Entered!");
        }
    }

    public void removeVisitor() {
        if(visitors > 0) {
            visitors--;
            System.out.println("Visitor Existed!");
        }
    }
}
