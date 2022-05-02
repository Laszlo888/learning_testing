package farm;

public class Animal {
    Integer hunger;
    Integer thirst;

    public Animal() {
        hunger = 50;
        thirst = 50;
    }

    public void eat() {
        hunger--;
    }

    public void drink() {
        thirst--;
    }

    public void play() {
        hunger++;
        thirst++;
    }
}
