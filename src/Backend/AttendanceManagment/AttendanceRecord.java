package Backend.AttendanceManagment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AttendanceRecord {

    private Date date;
    private Date timeIn;
    private Date timeOut;

    /**
     * Initializes a new instance of the AttendanceRecord class with the current date
     * and null values for timeIn and timeOut.
     * This constructor is commonly used to create a new attendance record when an employee starts a workday.
     */
    public AttendanceRecord() {
        // Sets the date to the current date.
        date = new Date();

        // Initializes timeIn and timeOut to null, indicating that the employee has not yet clocked in or out.
        timeIn = null;
        timeOut = null;
    }


    /**
     * Initializes a new instance of the AttendanceRecord class with the specified date, timeIn, and timeOut values.
     * This constructor is commonly used when parsing or editing an AttendanceRecord.
     *
     * @param date    The date for which the attendance record is being created.
     * @param timeIn  The time when the employee clocked in.
     * @param timeOut The time when the employee clocked out.
     */
    public AttendanceRecord(Date date, Date timeIn, Date timeOut) {
        // Assigns the provided values to the corresponding fields.
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    /**
     * Sets the date of the attendance record.
     *
     * @param date   The date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the clock-in time of the attendance record.
     *
     * @param timeIn   The time when the employee clocked in.
     */
    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * Sets the clock-out time of the attendance record.
     *
     * @param timeOut   The time when the employee clocked out.
     */
    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * Gets the date of the attendance record.
     *
     * @return   The date of the attendance record.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the clock-in time of the attendance record.
     *
     * @return   The clock-in time of the attendance record.
     */
    public Date getTimeIn() {
        return timeIn;
    }

    /**
     * Gets the clock-out time of the attendance record.
     *
     * @return   The clock-out time of the attendance record.
     */
    public Date getTimeOut() {
        return timeOut;
    }

    /**
     * Returns a string representation of the attendance record, including date, time in, and time out.
     *
     * @return   A string representing the attendance record.
     */
    public String toString() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        return "Date: " + dateFormatter.format(date)  +
                "\nTime in: " + timeFormatter.format(timeIn) +
                "\nTime out: " + timeFormatter.format(timeOut);

    }

}
