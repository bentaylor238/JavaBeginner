public class JulianDate extends Date {
    /**
     * This is the default constructor which sets the Julian Date for the current day
     */
    JulianDate() {
        // Sets the day month and year to when the Julian calendar begins
        year = 1;
        month = 1;
        day = 1;
        // Adds the difference in the number of days and when the clock that counts milliseconds begins
        day +=719164;
        // Calculates the amount of milliseconds since the date the clock begins, Jan 1, 1970, and adjusts for timezone
        long timePassed = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        // These are conversions to make timePassed into days
        timePassed /= 1000;
        timePassed /= 60;
        timePassed /= 60;
        timePassed /= 24;
        //This is how many days have passed since Jan 1, 0001
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
    JulianDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * This method calls the private leap year method and returns its results for if the year is a leap year
     * @return true if the current year is a leap year
     */
    @Override
    public boolean isLeapYear() {
        return isLeapYear(year);
    }
}
