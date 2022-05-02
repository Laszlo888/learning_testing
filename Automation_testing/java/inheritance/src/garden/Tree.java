package garden;

public class Tree {
    String color;
    private double currentWaterAmount;
    private double waterCanGet;

    public Tree(String color) {
        currentWaterAmount = (int) (Math.random() * 10);
        waterCanGet = 0.4;
        this.color = color;
    }

    public double getCurrentWaterAmount() {
        return currentWaterAmount;
    }

    public double getWaterCanGet() {
        return waterCanGet;
    }

    public void setCurrentWaterAmount(double currentWaterAmount) {
        this.currentWaterAmount = currentWaterAmount;
    }
}
