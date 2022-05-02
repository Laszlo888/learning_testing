package farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {

  // Reuse your Animal class
  // Create a Farm class
  // it has a list of Animals
  // it has a limit that defines how many animals can be kept in the Farm
  // it has two methods:
  // breed() -> creates a new animal if there's place for it
  // sell() -> removes the least hungry animal

  List<Animal> animals = new ArrayList<>();

    int limit;

    public Farm() {
        limit = 112;
    }

    void breed() {
        if (limit >= 1) {
            Animal animal = new Animal();
        }
    }

    void sell() {
        int min = 5000;
        int ind = 0;
        for (int i = 0; i < animals.size() - 1; i++) {
            if (animals.get(i).hunger <= min) {
                min = animals.get(i).hunger;
                ind = i;
            }
        }
        animals.remove(ind);
    }
}
