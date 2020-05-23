public class Square extends Rectangle {
    public Square() {
        super(5, 5);

        System.out.println("In Square()");
    }

    @Override
    public double calcArea() {
        return width * width;
    }
}
