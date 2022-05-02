package sharpieSet;

public class Sharpie {
    String color;
    Double width;
    Double inkAmount;

    public Sharpie(String color, Double width) {
        this.color = color;
        this.width = width;
        inkAmount = 100.0;
    }

    public void use(){
        inkAmount = inkAmount -10;
    }
}
