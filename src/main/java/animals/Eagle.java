package src.main.java.animals;

public class Eagle extends ZooAnimal implements Flyable, Runnable {

    public Eagle (int health, int size) {
        super(health, size);
    }

    public void run() {

    }

    public void fly() {

    }

    public int getTopSpeed() {
        return 0;
    }

}
