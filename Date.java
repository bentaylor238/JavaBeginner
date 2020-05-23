public class Date {
    /**
     * This is the default constructor which sets the Date as 0
     */
    Date() {
        // Sets the day month and year to 0 as a default, but is overridden in the subclasses
        year = 0;
        month = 0;
        day = 0;
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
     * This method is set as default false because it will be overridden in the subclasses
     * @return false as the default
     */
    public boolean isLeapYear() {
        return false;
    }

    /**
     * This method prints the short date as mm/dd/yyyy
     */
    public void printShortDate() {
        System.out.println(month + "/" + day + "/" + year);
    }

    /**
     * The method prints the date as Monthname day, year, or the long date printing
     */
    public void printLongDate() {
        System.out.println(getMonthName(month) + " " + day + ", " + year);
    }

    /**
     * Calls the getMonthName method and returns what it returns, or in other words the name of the current month
     * @return the string name of the month
     */
    public String getCurrentMonthName() {
        return getMonthName(month);
    }

    /**
     * @return returns the current month number 1-12
     */
    public int getCurrentMonth() {
        return month;
    }

    /**
     * returns the year number stored in the protected variable
     * @return
     */
    public int getCurrentYear() {
        return year;
    }

    /**
     * @return returns what number day the date is
     */
    public int getCurrentDayOfMonth() {
        return day;
    }

    // 3 protected variables that store the year, month and day numbers
    protected int year;
    protected int month;
    protected int day;

    /**
     * Determines if the present year is a leap year based on a basic algorithim which is the Julian algorithm,
     * but this is overridden in the gregorian class
     * @param year present year
     * @return returns true if it is a leap year
     */
    protected boolean isLeapYear(int year) {
        boolean leapYear = (year % 4 == 0);
        return leapYear;
    }

    /**
     * Determines how many days are in the sent month based on if it's a leap year and what month it is.
     * @param year uses this to find if it's a leap year and adjust February's days
     * @param month uses this to determine the number of days to return
     * @return the number of days in that month
     */
    protected int getNumberOfDaysInMonth(int year, int month) {
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
    protected String getMonthName(int month) {
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