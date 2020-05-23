public class Circle extends Shape {
    public Circle() {
        // Invoke parent class constructor
        super("Beige", false);

        radius = 5;
    }

    @Override
    public double calcArea() {
        // super accesses parent class
        return super.calcArea() + Math.PI * Math.pow(radius, 2);
    }

    private double radius;
}
