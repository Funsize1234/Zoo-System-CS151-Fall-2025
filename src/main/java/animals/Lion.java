package src.main.java.animals;

public class Lion extends ZooAnimal implements Runnable {

    //mph
    public static final int TOP_SPEED = 50;
    private int currentSpeed = 0;
    private int jumpCount = 0;


    public Lion(int health, int size) {
        super(health, size, "ground");
    }

    @Override
    public void run() {
        System.out.println("Lion runs");
        currentSpeed = Math.min(TOP_SPEED, currentSpeed + 5);
    }

    @Override
    public void stop() {
        currentSpeed = 0;
    }

    @Override
    public void jump()  {
        System.out.println("Lion jumps");
        jumpCount++;
    }

    @Override
    public int getJumpCount() {
        return jumpCount;
    }

    @Override
    public boolean isRunning()  {
        return currentSpeed > 0;
    }

    @Override
    public int getTopSpeed() {
        return TOP_SPEED;
    }
    
}
