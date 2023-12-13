package Backend.AttendanceManagment;

import java.util.Date;

public class AttendanceRecord {

    private Date date;
    private Date timeIn;
    private Date timeOut;

    /**
     * Constructs an AttendanceRecord object
     */
    public AttendanceRecord() {
        date = new Date();
        timeIn = null;
        timeOut = null;
    }

    /**
     * Sets the Date of the record
     * @param date the date to be set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the timeIn of the record
     * @param timeIn the time-in to be set
     */
    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * Sets the timeOut of the record
     * @param timeOut the time-out to be set
     */
    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * Retrieves the Date
     * @return the Date of the record
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retrieves the timeIn
     * @return the timeIn of the record
     */
    public Date getTimeIn() {
        return timeIn;
    }

    /**
     * Retrieves the timeOut
     * @return the timeOut of the record
     */
    public Date getTimeOut() {
        return timeOut;
    }

}
