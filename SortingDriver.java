/**
 * Assignment 4 for CS 1410
 * This program evaluates the bubble and selection sorts versus each other.
 *
 * @author Benjamin Taylor A02021288 2/13/2018
 */
public class SortingDriver {
    /**
     * This class generates arrays of ints and then uses two sorting methods and measures the time it takes for each
     * @param args main method parameters
     */
    public static void main(String[] args) {
        // Output title
        System.out.println("--- Timing Results ---");

        // These two classes are created to store the statistics about the data being collected
        SortingStats BubbleSortStats = new SortingStats();
        SortingStats SelectionSortStats = new SortingStats();

        // The for loop iterates from 1000 - 10,000, creating arrays every thousand numbers.
        // It then calls the two methods to sort the two created arrays and then calls the print to print the statistics
        for(int i = 1000; i < 11000; i+=1000) {
            int[] dataSort = generateNumbers(i);
            int[] dataBubble = generateNumbers(i);
            SelectionSortStats = selectionSort(dataSort);
            BubbleSortStats = bubbleSort(dataBubble);
            System.out.println();
            printTimeResults(i, SelectionSortStats, BubbleSortStats);
        }

    }

    /**
     * This method creates the specified size array and fills it with random numbers between 0 and 100,000
     * @param howMany This takes how large the array will be
     * @return returns an array of size howMany with random numbers
     */
    public static int[] generateNumbers(int howMany) {
        int[] theArray = new int[howMany];
        for(int i = 0; i < howMany; i++) {
            theArray[i] = (int)(Math.random() * 100000);
        }

        return theArray;
    }

    /**
     *
     * @param data The array to be sorted
     * @return The SortingStats with statistics of time taken to sort the array
     * This method uses the bubble sort, which compares adjacent members of arrays and puts the smaller one first.
     * It goes one by one through the whole array the size of the array times to guarantee they're all in the correct
     * order.
     */
    public static SortingStats bubbleSort(int[] data) {
        // Statistic tracker object
        SortingStats Bubble = new SortingStats();
        // Begin time
        long start = System.currentTimeMillis();
        // Sorting loops
        for(int j = 0; j < data.length; j++) {
            for (int i = 0; i < (data.length - 1); i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    Bubble.incrementSwapCount();
                }
                Bubble.incrementCompareCount();
            }
        }
        // End sort time and results are returned with the object.
        long end = System.currentTimeMillis();
        long duration = end - start;
        Bubble.setTime(duration);
        return Bubble;
    }

    /**
     * @param data The random array sent to the method
     * @return Returns the object with the statistics for the method
     * This method iterates through the array as many times as the length, finding the smallest number and placing it in
     * the front of the array or in the next smallest place.
     */
    public static SortingStats selectionSort(int[] data) {
        // Statistic object that will be returned
        SortingStats Selection = new SortingStats();
        // Start time for sorting
        long start = System.currentTimeMillis();
        // Loops that will look through the entire array to find the smallest, place it at the front and repeat the
        // lenght of the array times.
        for(int i = 0; i < data.length; i++) {
            int smallest = data[i];
            int smallestIndex = i;
            int temp;
            for(int j = (i + 1); j < data.length; j++) {
                Selection.incrementCompareCount();
                if(data[j] < smallest) {
                    smallest = data[j];
                    smallestIndex = j;
                }
            }
            if(smallest < data[i]) {
                temp = data[i];
                data[i] = data[smallestIndex];
                data[smallestIndex] = temp;
                Selection.incrementSwapCount();
            }
        }
        // finish time and finds the time to sort, then returns this with the object.
        long end = System.currentTimeMillis();
        long duration = end - start;
        Selection.setTime(duration);
        return Selection;
    }

    /**
     * Used for testing purposes to check if the array was sorted properly
     * @param data the generated array needing sorted
     */
    public static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    /**
     *
     * @param howMany This tells how long the array is
     * @param Selection This is the object with the time and statistics for the selection sort method
     * @param Bubble This is the object with the time and statistics for the bubble sort method
     *               This method reports how long each method took to sort the varying sized arrays and tells how large
     *               the arrays sorted were.
     */
    public static void printTimeResults(int howMany, SortingStats Selection, SortingStats Bubble) {
        System.out.println("Number of items      : " + howMany);
        System.out.println("Bubble sort time     : " + Bubble.getTimeInMs());
        System.out.println("Selection sort time  : " + Selection.getTimeInMs());
    }
}
