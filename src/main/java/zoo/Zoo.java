package src.main.java.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private int capacity;
    private int visitors;
    private int points;
    private List<Exhibit> exhibits;
    private int totalAnimals;

    public Zoo() {
        this.visitors = 49;
        this.points = 200;
        this.exhibits = new ArrayList<>();
        this.totalAnimals = 0;
        this.capacity = 50;
    }

    public Zoo(int capacity, int points) {
        this.capacity = capacity;
        this.visitors = 0;
        this.points = points;
        this.exhibits = new ArrayList<>();
        this.totalAnimals = 0;
    }

    public void addVisitor() {
        if(visitors < capacity) {
            visitors++;
            System.out.println("Visitor Entered!");
        } else {
            System.out.println("Zoo has reached Maximum Capacity! Closing for Reconstruction");
            System.exit(0);
        }
    }

    public void removeVisitor() {
        if(visitors > 0) {
            visitors--;
            System.out.println("Visitor Exited!");
        }
    }
    
    //every 10 points, a visitor is added
    public void addPoints(int amount) {
        points += amount;

        if (amount >= 10) {
            addVisitor();
        }
    }
    
    public boolean spendPoints(int amount) {
        if (points >= amount) {
            points -= amount;
            return true;
        }
        return false;
    }
    
    public void addExhibit(Exhibit exhibit) {
        exhibits.add(exhibit);
    }

    public boolean removeExhibit(Exhibit exhibit) {
        return exhibits.remove(exhibit);
    }
    
    //every 2 animals, a visitor is added
    public void addAnimal() {
        totalAnimals++;

        if (totalAnimals % 2 == 0) {
            addVisitor();
        }
    }

    public boolean removeAnimal() {
        if (totalAnimals <= 0)
            return false;
        --totalAnimals;
        return true;
    }
    
    public int getPoints() {
        return points;
    }
    
    public int getVisitors() {
        return visitors;
    }
    
    public int getTotalAnimals() {
        return totalAnimals;
    }
    
    public List<Exhibit> getExhibits() {
        return exhibits;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
