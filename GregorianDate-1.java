public class GregorianDate extends Date {
    // This default constructor is for the gregorian date class
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
     * Overloaded constructor that assigns the parent class variables year, month and day to the values sent
     * @param year the year sent when the object is created
     * @param month the month sent when the object is created
     * @param day the day sent when the object is created
     */
    GregorianDate(int year, int month, int day) {
        // The year, month and day sent are then assigned to the protected variables inherited from the parent class
        // of the object
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * This method calls the leap year method of the subclass and returns its results for if the year is a leap year
     * Both this isLeapYear and the other override the parent class methods
     * @return true if the current year is a leap year
     */
    @Override
    public boolean isLeapYear() {
        return isLeapYear(year);
    }

    /**
     * Determines if the present year is a leap year based on gregorian algorithim, every 4 years except for every 100
     * years, discounting the 400th year
     * Overrides the parent method isLeapYear
     * @param year present year
     * @return returns true if it is a leap year
     */
    @Override
    public boolean isLeapYear(int year) {
        boolean leapYear = ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
        return leapYear;
    }
}
