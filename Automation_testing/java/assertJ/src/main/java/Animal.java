public class Animal {

    // Search back in your own project directory the Animal class you made on the OO workshop.
    // Copy it to your current project.
    // Create an AnimalTest class in your project.
    // Instantiate an Object from your class in the test class.
    // Use @BeforeEach to reset the Animal before every test.
    // Create at least one test case for every method.

    Integer hunger;
    Integer thirst;

    public Animal() {
        hunger = 50;
        thirst = 50;
    }

    public Integer getHunger() {
        return hunger;
    }

    public Integer getThirst() {
        return thirst;
    }

    public void eat() {
        hunger--;
    }

    public void drink() {
        thirst--;
    }

    public void play() {
        hunger++; thirst++;
    }
}
