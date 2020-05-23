public class Rectangle extends Shape {


    public Rectangle() {
        super("Blue", true);
    }

    public Rectangle(double w, double h) {
        width = w;
        height = h;

        System.out.println("In Rectangle()");
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    protected double width;
    protected double height;
}
