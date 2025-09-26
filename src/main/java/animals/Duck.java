package src.main.java.animals;

public class Duck extends ZooAnimal implements Flyable, Runnable {

    public Duck (int health, int size) {
        super(health, size);
    }

    public void run() {

    }

    public void fly() {

    }

    public void swim() {

    }
    
    public int getTopSpeed() {
        return 0;
    }

}
