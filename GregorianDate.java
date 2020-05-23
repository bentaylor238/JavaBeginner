/**
 * Assignment 5 for CS 1410
 *This class produces dates based on the Gregorian calendar
 *
 * @author Benjamin Taylor A02021288
 */
public class GregorianDate {
    /**
     * This is the default constructor which sets the Gregorian Date for the current day
     */
    GregorianDate() {
        // Sets the day month and year to when currentTimeMillis begins counting
        year = 1970;
        month = 1;
        day = 1;
        // Calculates the amount of milliseconds since the date and adjusts for timezone
        long timePassed = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        // These are conversions to make timePassed into days
        timePassed /= 1000;
        timePassed /= 60;
        timePassed /= 60;
        timePassed /= 24;
        //This is how many days have passed since Jan 1, 1970
        day += timePassed;
        // This loop adjusts the day, month and year until the day total gets below the amount of days in the ending month
        while (day > getNumberOfDaysInMonth(year, month)) {
            day -= getNumberOfDaysInMonth(year, month);
            month++;
            if(month > 12) {
                month = 1;
                year++;
            }
        }
    }

    /**
     * Overloaded constructor that assigns year, month and day to the values sent
     * @param year the year sent when the object is created
     * @param month the month sent when the object is created
     * @param day the day sent when the object is created
     */
    GregorianDate(int year, int month, int day) {
        // The year, month and day sent are then assigned to the private variables of the object
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * This method takes a number and adds that many days to the current date
     * @param days this is the number of days that the user decides to add to the current date
     */
    public void addDays(int days) {
        // Add the sent days and then loop to adjust the date
        day += days;
        while (day > getNumberOfDaysInMonth(year, month)) {
            day -= getNumberOfDaysInMonth(year, month);
            month++;
            if(month > 12) {
                month = 1;
                year++;
            }
        }
    }

    /**
     * This method subtracts the number of days sent and adjusts the date accordingly
     * @param days the number of days to be subtracted
     */
    public void subtractDays(int days) {
        // subtract the days from the current day and adjust the date with a loop
        day -= days;
        while (day < 1) {
            month--;
            if(month < 1) {
                month = 12;
                year--;
            }
            day = (getNumberOfDaysInMonth(year, month) + day);

        }
    }

    /**
     * This method calls the private leap year method and returns its results for if the year is a leap year
     * @return true if the current year is a leap year
     */
    public boolean isLeapYear() {
        return isLeapYear(year);
    }

    /**
     * This method prints the gregorian date as mm/dd/yyyy
     */
    public void printShortDate() {
        System.out.println(month + "/" + day + "/" + year);
    }

    /**
     * The method prints the date as Monthname day, year
     */
    public void printLongDate() {
        System.out.println(getMonthName(month) + " " + day + ", " + year);
    }

    /**
     * Calls the getMonthName method and returns what it returns, or in other words the name of the current month
     * @return
     */
    public String getCurrentMonthName() {
        return getMonthName(month);
    }

    /**
     *
     * @return returns the current month number 1-12
     */
    public int getCurrentMonth() {
        return month;
    }

    /**
     * returns the year number stored in the private variable
     * @return
     */
    public int getCurrentYear() {
        return year;
    }

    /**
     *
     * @return returns what number day the date is
     */
    public int getCurrentDayOfMonth() {
        return day;
    }

    // 3 private variables  that store the year, month and day numbers
    private int year;
    private int month;
    private int day;

    /**
     * Determines if the present year is a leap year based on gregorian algorithim, every 4 years except for every 100
     * years, discounting the 400th year
     * @param year present year
     * @return returns true if it is a leap year
     */
    private static boolean isLeapYear(int year) {
        boolean leapYear = ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
        return leapYear;
    }

    /**
     * Determines how many days are in the sent month based on if it's a leap year and what month it is.
     * @param year uses this to find if it's a leap year and adjust February's days
     * @param month uses this to determine the number of days to return
     * @return the number of days in that month
     */
    private static int getNumberOfDaysInMonth(int year, int month) {
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
                // February must be checked for if it is a leap year and then returns based on this result
            case 2:
                boolean isLeap = isLeapYear(year);
                if(isLeap) {
                    return 29;
                }
                else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    /**
     * This method returns the name of the month
     * @param month Takes the month number and returns its name
     * @return
     */
    private static String getMonthName(int month) {
        switch(month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Incorrect input";
        }
    }
}
