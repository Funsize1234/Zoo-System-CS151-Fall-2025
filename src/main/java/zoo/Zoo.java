package src.main.java.zoo;

import java.util.ArrayList;
import java.util.List;

import src.main.java.animals.ZooAnimal;
import src.main.java.exceptions.AnimalNotFoundException;
import src.main.java.exceptions.ExhibitMismatchException;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Zoo {
    private int capacity;
    private int visitors;
    private int points;
    private List<Exhibit> exhibits;
    public static int instances = 0;
    public static final int MAX_INSTANCES = 1;

    public Zoo() throws MaxInstancesExceededException {
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Zoo", instances, MAX_INSTANCES);
        }

        this.visitors = 0;
        this.points = 500;
        this.exhibits = new ArrayList<>();
        this.capacity = 50;
    }

    public Zoo(int capacity, int points) throws MaxInstancesExceededException {
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Zoo", instances, MAX_INSTANCES);
        }

        this.capacity = capacity;
        this.visitors = 0;
        this.points = points;
        this.exhibits = new ArrayList<>();
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
    
    public void addExhibit(Exhibit exhibit, int habitatCost) {
        exhibits.add(exhibit);
    }

    public boolean removeExhibit(Exhibit exhibit) {
        return exhibits.remove(exhibit);
    }
    
    //every 2 animals, a visitor is added
    public void addAnimal(Exhibit exhibit, ZooAnimal animal) throws ExhibitMismatchException {
        exhibit.addAnimal(animal);
        if (getTotalAnimals() % 2 == 0) {
            addVisitor();
        }
    }

    public void removeAnimal(Exhibit exhibit, ZooAnimal animal) throws AnimalNotFoundException {
        exhibit.removeAnimal(animal);
    }
    
    public int getPoints() {
        return points;
    }
    
    public int getVisitors() {
        return visitors;
    }
    
    public int getTotalAnimals() {
        int count = 0;
        for(Exhibit e : exhibits) {
            count += e.getTotalAnimals();
        }
        return count;
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
