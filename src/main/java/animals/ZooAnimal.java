package src.main.java.animals;

public abstract class ZooAnimal {
    public final static int MAX_HEALTH = 100;
    protected int health; 
    protected int size;

    public ZooAnimal (int health, int size) {
        this.health = health;
        this.size = size;
    }

    public void feed(int amount) {
        if (health == MAX_HEALTH) {
            System.out.println("Too full to eat");
        }
        else if (health + amount > MAX_HEALTH) {
            health = MAX_HEALTH;
            return;
        }   
        health += amount/size; // basic expression for now but if we want hunger/health to be more complicated we can add more later
    }

}
