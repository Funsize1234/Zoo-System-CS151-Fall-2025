package src.main.java.zoo;
import java.util.ArrayList;

public abstract class ZooAnimal {
    public final static int MAX_HEALTH = 100;
    protected int health; 
    protected int size;
    protected ArrayList<String> type;

    public ZooAnimal (int health, int size, String[] type) {
        this.health = health;
        this.size = size;
        for(String t : type) {
            if(t == "ground" || t == "water" || t == "air") {
                this.type.add(t);
            }
            else {
                throw new IllegalArgumentException("Invalid habitat type");
            }
        }

        if(this.type.size() == 0) {
            throw new IllegalArgumentException("No habitat type specified");
        }
        
    }

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

    public ArrayList<String> getTypes() {
        return type;
    }

}
