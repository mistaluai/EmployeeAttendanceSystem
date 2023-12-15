package Backend.AttendanceManagment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AttendanceRecord {

    private Date date;

    private Date timeIn;

    private Date timeOut;

    public AttendanceRecord() {
        date = new Date();
        timeIn = null;
        timeOut = null;
    }

    public AttendanceRecord(Date date, Date timeIn, Date timeOut) {
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Date getDate() {
        return date;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public String toString() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        return "Date: " + dateFormatter.format(date)  +
                "\nTime in: " + timeFormatter.format(timeIn) +
                "\nTime out: " + timeFormatter.format(timeOut);

    }
}
