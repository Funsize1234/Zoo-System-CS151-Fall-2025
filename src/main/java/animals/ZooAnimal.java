package src.main.java.animals;

public abstract class ZooAnimal {
    public final static int MAX_HEALTH = 100;
    protected int health; 
    protected int size;
    protected String name;
    protected int purchaseCost;
    protected int basicPoints;
    protected int trickPoints;
    private boolean alive;

    public ZooAnimal (int health, int size, int purchaseCost, int basicPoints, int trickPoints) {
        this.name = ""; // Will be set later
        this.purchaseCost = purchaseCost;
        this.basicPoints = basicPoints;
        this.trickPoints = trickPoints;
        this.alive = this.health > 0;
        setSize(size);
        setHealth(health);
    }

    public void feed(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid feed amount");
            return;
        }
        if (health >= MAX_HEALTH) {
            System.out.println("Too full to eat");
            return;
        }
        health += amount / size;
        if (health > 0) {
            alive = true;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size <= 0) {
            System.out.println("Invalid size");
            return;
        }
        this.size = size;
    }

    public void setHealth(int newHealth) {
        health = Math.max(0, Math.min(MAX_HEALTH, newHealth));
        alive = health > 0;
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
        if (cost < 0) {
            System.out.println("Purchase cost cannot be negative.");
            return;
        }
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

    public int decreaseHealth(int amount) {
        if (amount <= 0) {
            return 0;
        }
        int actualDecrease = Math.min(amount, health);
        health -= actualDecrease;
        if (health == 0) {
            alive = false;
        }
        return actualDecrease;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getType() {
        return "Default";
    }

    @Override
    public String toString() {
        return this.name + " (Type: " + this.getType() + " / Health: " + this.health + "/" + MAX_HEALTH + ")";
    }

}
