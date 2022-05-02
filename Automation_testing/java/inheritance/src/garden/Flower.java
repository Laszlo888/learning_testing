package garden;

public class Flower {
    String color;
    private double currentWaterAmount;
    private double waterCanGet;

    public Flower(String color){
        currentWaterAmount = (int) (Math.random()*5);
        waterCanGet = 0.75;
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
