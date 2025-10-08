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

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }

    @Override
    public void jump() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'jump'");
    }

    @Override
    public boolean isRunning() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isRunning'");
    }

    @Override
    public int getJumpCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJumpCount'");
    }

}
