public class Shape {

    public Shape() {

    }

    public Shape(String color, boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;

        System.out.println("In Shape()");
    }

    public double calcArea() {
        return 0.0;
    }

    public double calcPerimeter() {
        return 0.0;
    }

    protected String color;
    protected boolean isFilled;
}
