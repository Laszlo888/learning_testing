package garden;

import java.util.List;

public class Garden {

    List<Flower> flowers;
    List<Tree> trees;

    public Garden(List<Flower> flowers, List<Tree> trees) {
        this.flowers = flowers;
        this.trees = trees;
    }

    void watering(int amount) {

        double countShouldBeWatered = 0;

        //counting who needs water
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getCurrentWaterAmount() < 5) {
                countShouldBeWatered++;
            }
        }
        for (int i = 0; i < trees.size(); i++) {
            if (trees.get(i).getCurrentWaterAmount() < 10) {
                countShouldBeWatered++;
            }
        }

        double wateringWithEqualAmount = 40.0 / countShouldBeWatered;

        //watering with equal amount
        if (countShouldBeWatered != 0) {
            System.out.println();
            System.out.println("After watering with " + amount + ":");
            for (int i = 0; i < flowers.size(); i++) {
                if (flowers.get(i).getCurrentWaterAmount() < 5) {
                    flowers.get(i).setCurrentWaterAmount(flowers.get(i).getCurrentWaterAmount() + wateringWithEqualAmount*flowers.get(i).getWaterCanGet());
                }
            }
            for (int i = 0; i < trees.size(); i++) {
                if (trees.get(i).getCurrentWaterAmount() < 10) {
                    trees.get(i).setCurrentWaterAmount(trees.get(i).getCurrentWaterAmount() + wateringWithEqualAmount*trees.get(i).getWaterCanGet());
                }
            }
        } else {
            System.out.println();
            System.out.println("There is no need watering.");
        }
    }

    void info(Garden garden) {
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getCurrentWaterAmount() < 5) {
                System.out.println("The " + flowers.get(i).color + " Flower needs water.  current water amount: " + flowers.get(i).getCurrentWaterAmount());
            } else {
                System.out.println("The " + flowers.get(i).color + " Flower doesn't need water.  current water amount: " + flowers.get(i).getCurrentWaterAmount());
            }
        }

        for (int i = 0; i < trees.size(); i++) {
            if (trees.get(i).getCurrentWaterAmount() < 10) {
                System.out.println("The " + trees.get(i).color + " Tree needs water.  current water amount: " + trees.get(i).getCurrentWaterAmount());
            } else {
                System.out.println("The " + trees.get(i).color + " Tree doesn't need water.  current water amount: " + trees.get(i).getCurrentWaterAmount());
            }
        }
    }
}
