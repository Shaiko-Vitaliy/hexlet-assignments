package exercise;

// BEGIN
public class Cottage implements Home{
    private final double area;
    private final int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (this.getArea() > another.getArea()) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.area + " метров";
    }
}
// END
