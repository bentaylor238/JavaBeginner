/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 * Jan 30, 2018
 * @author Benjamin Taylor
 */
public class Inside {
    /**
     * This is the primary code that tests whether the given points are within given circles and rectangles.
     */
    public static void main(String[] args) {
        // Given data values
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };
        // Prints out the report of points and whether they're within the circles
        System.out.println("--- Report of Points and Circles ---");
        System.out.println();
        // These for loops are used to go through the different point array values and array circle values
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 4; j++) {
                // Prints the point that is being tested
                reportPoint(ptX[j], ptY[j]);
                // Calls the bool method that determines whether the point is within the circle and if true prints is
                // inside and if false prints is outside.
                if(isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i])) {
                    System.out.print(" is inside ");
                }

                else {
                    System.out.print(" is outside ");
                }
                // Prints the circle being tested with
                reportCircle(circleX[i], circleY[i], circleRadius[i]);
            }
        }

        // Prints spaces and the title for the rectangle and point report
        System.out.println();
        System.out.println("--- Report of Points and Rectangles ---");
        System.out.println();

        // These for loops run through the arrays of points and arrays of rectangle values and then test the point
        // to know whether it is inside the rectangle
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 4; j++) {
                // Prints the point being tested
                reportPoint(ptX[j], ptY[j]);
                // Calls the method that tests whether the point is inside the rectangle and if true then it prints
                // inside otherwise it prints outside
                if(isPointInsideRectangle(ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i])) {
                    System.out.print(" is inside ");
                }

                else {
                    System.out.print(" is outside ");
                }
                // Prints the rectangle on each line that's being tested on
                reportRectangle(rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
            }
        }
    }

    // This Prints out the Point and its x and y value
    public static void reportPoint(double x, double y) {
        System.out.print("Point(" + x + ", " + y + ")");
    }

    // This prints the circle center point and radius
    public static void reportCircle(double x, double y, double r) {
        System.out.println("Circle(" + x + ", " + y + ") Radius: " + r);
    }

    // This prints the Rectangle with each sides value
    public static void reportRectangle(double left, double top, double width, double height) {
        System.out.println("Rectangle(" + left + ", " + top + ", " + (left + width) + ", " + (top + height));
    }

    // Tests the given point and given circle with radius using the distance formula to find out whether the point
    // is a distance less than the radius and tells true if so and false if greater than the radius
    public static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        double distanceToCenter = Math.sqrt(Math.pow((circleX - ptX), 2.0) + Math.pow((circleY - ptY), 2.0));
        if(distanceToCenter <= circleRadius) {
            return true;
        }
        else {
            return false;
        }
    }

    // Tests whether the sent point is inside the given rectangle through booleans that check the x and y values to be
    // within the left and right and top and bottom values and returns true if both are within those respective values
    public static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        boolean insideWidth = (rLeft <= ptX && ptX <= (rLeft + rWidth));
        boolean insideHeight = (rTop <= ptY && ptY <= (rTop + rHeight));
        if(insideHeight && insideWidth) {
            return true;
        }

        else {
            return false;
        }
    }
}
