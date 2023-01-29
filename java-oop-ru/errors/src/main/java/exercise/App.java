package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            int roundCircle = (int) Math.round(circle.getSquare());
            System.out.println(roundCircle);
        } catch (NegativeRadiusException e) {
            System.out.println(e.getErrorMessage());
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
