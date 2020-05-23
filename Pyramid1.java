/**
 * @author Benjamin Taylor
 * Assignment #2 Pyramid1
 * 01/25/2018
 */

import java.util.Scanner;

/**
 * This program asks the user for the number of lines and then creates a pyramid that has 1 at the top and then counts
 * up going down
 */
public class Pyramid1 {
    /**
     * The method asks the user for lines and then adds one and moves down
     * @param args Command line argument
     */
    public static void main(String[] args) {
        // Asks for the number of lines
        System.out.print("Please enter how many lines: ");
        Scanner input = new Scanner(System.in);
        int lines = input.nextInt();
        // Measures how long the user chosen number is to later format width
        int howLong = Integer.toString(lines).length() + 1;
        // The first for loop controls the row number
        for (int i = 1; i <= (lines + 1); i++) {
            // This first set of for loops controls the number of spaces preceding the first appearing number on
            // that row
            for (int k = (lines + 1); k > i; k--) {
                for (int m = 0; m < howLong; m++) {
                    System.out.print(" ");
                }
            }
            // This next for loop format prints the left side of the pyramid of numbers
            for (int l = (i - 1); l > 1; l--) {
                System.out.printf("%" + howLong + "d", l);
            }
            // The last for loop format prints the middle and right half of the pyramid numbers
            for (int j = 1; j < i; j++) {
                System.out.printf("%" + howLong + "d", j);
            }
            // Starts the next line of the pyramid
            System.out.print("\n");
        }
    }
}
