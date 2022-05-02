import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnimalTest {

    Animal animal;

    @BeforeEach
    public void setup() {
        animal = new Animal();
    }

    @Test
    void eatDecreaseHungerByOne() {
        animal.eat();
        assertThat(animal.getHunger()).isEqualTo(49);
    }

    @Test
    void drinkDecreaseThirstByOne() {
        animal.drink();
        assertThat(animal.getThirst()).isEqualTo(49);
    }

    @Test
    void playIncreaseHungerAndThirstByOne() {
        animal.play();
        assertThat(animal.getHunger()).isEqualTo(51);
        assertThat(animal.getThirst()).isEqualTo(51);
    }
}