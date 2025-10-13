package src.main.java.animals;

public abstract class ZooAnimal {
    public final static int MAX_HEALTH = 100;
    protected int health; 
    protected int size;
    protected String name;
    protected int purchaseCost;
    protected int basicPoints;
    protected int trickPoints;

    public ZooAnimal (int health, int size, int purchaseCost, int basicPoints, int trickPoints) {
        this.health = health;
        this.size = size;
        this.name = ""; // Will be set later
        this.purchaseCost = purchaseCost;
        this.basicPoints = basicPoints;
        this.trickPoints = trickPoints;
    }

    public void feed(int amount) {
        if (health == MAX_HEALTH) {
            System.out.println("Too full to eat");
        }
        else if (health + amount > MAX_HEALTH) {
            health = MAX_HEALTH;
            return;
        }
        health += amount/size;
    }

    public int getHealth() {
        return health;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPurchaseCost() {
        return purchaseCost;
    }
    
    public void setPurchaseCost(int cost) {
        this.purchaseCost = cost;
    }

    public int getBasicPoints() {
        return basicPoints;
    }

    public void setBasicPoints(int points) {
        this.basicPoints = points;
    }
    
    public int getTrickPoints() {
        return trickPoints;
    }

    public void setTrickPoints(int points) {
        this.trickPoints = points;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

}
