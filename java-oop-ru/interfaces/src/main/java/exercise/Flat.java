package exercise;

// BEGIN
public class Flat implements Home {
    private final double area;
    private final double balconyArea;
    private final int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return (this.area + this.balconyArea);
    }

    @Override
    public int compareTo(Home another) {
        if (this.getArea() > another.getArea()) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
