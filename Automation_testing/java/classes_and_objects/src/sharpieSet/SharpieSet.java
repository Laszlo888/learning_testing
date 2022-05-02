package sharpieSet;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {

  // Reuse your Sharpie class
  // Create SharpieSet class
  // it contains a list of Sharpie
  // it has a method that adds a new Sharpie to the set: add(sharpie)
  // it has a method that returns the number of usable Sharpies: countUsable() -> sharpie is
  // usable if it contains ink
  // it has a method that removes all unusable Sharpies: removeTrash()

    Sharpie sh1 = new Sharpie("green", 2.2);
    Sharpie sh2 = new Sharpie("brown", 3.0);
    Sharpie sh3 = new Sharpie("blue", 4.2);
    Sharpie sh4 = new Sharpie("black", 5.4);

    List<Sharpie> sharpies = new ArrayList<>();

    void add(Sharpie sharpie) {
        sharpies.add(sharpie);
    }

    int countUsable() {
        int counter = 0;
        for (int i = 0; i < sharpies.size(); i++) {
            if (sharpies.get(i).inkAmount == 0) {
            } else {
                counter++;
            }
        }
        return counter;
    }

    void removeTrash(){
        for (int i = 0; i < sharpies.size(); i++) {
            if (sharpies.get(i).inkAmount == 0) {
                sharpies.remove(i);
            }
        }
    }

}
