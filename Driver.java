public class Driver {
    public static void main(String[] args) {
        Circle a = new Circle();
        double area = a.calcArea();

        // Square constructor calls Rectangle ctor and Shape ctor
        Square mySquare = new Square();
    }

    private Circle composedCircle;
    private Square composedSquare;
}
