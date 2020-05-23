/**
 * @author Benjamin Taylor
 * Assignment #2 Pyramid2
 * 01/25/2018
 */

import java.util.Scanner;
/**
 * This program asks the user for the number of lines and then creates a pyramid scheme with multiples of 2
 */
public class Pyramid2 {
    /**
     * This method asks the user for the number of lines and then multiplies by two on each inward level
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Asks for the number of lines
        System.out.print("Please enter how many lines: ");
        Scanner input = new Scanner(System.in);
        int lines = input.nextInt();
        // Calculates the largest number that will be in the pyramid to know how wide the columnwidth should be
        int lastNum = (int)Math.pow(2.0 , (double)(lines - 1));
        // Calculates column width
        int howLong = Integer.toString(lastNum).length() + 1;

        // This is what prints the pyramid, the outer for loop controls the row number
        for (int i = 1; i <= (lines); i++) {

            // This for loop and nested for loop puts the necessary pre spaces before the first occuring number on
            // each row
            for (int k = (lines + 1); k > i; k--) {
                for (int m = 0; m < howLong; m++) {
                    System.out.print(" ");
                }
            }

            // This for loop prints the left half of the pyramid of numbers
            for (int l = 1; l < ((int)Math.pow(2.0, (double)(i-1))); l*=2) {
                System.out.printf("%" + howLong + "d", l);
            }

            // This for loop prints the middle column and right half of the pyramid
            for (int j = ((int)Math.pow(2.0, (double)(i - 1))); j > 0; j/=2) {
                System.out.printf("%" + howLong + "d", j);
            }
            // Prints a new line for the next row of the pyramid
            System.out.print("\n");
        }
    }
}
