package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;
import java.util.Date;

public abstract class AttendanceState {

    protected AttendanceManager attendanceManager;
    protected AttendanceRecord attendanceRecord;
    public AttendanceState(AttendanceManager attendanceManager) {
        this.attendanceManager = attendanceManager;
        attendanceRecord = new AttendanceRecord(new Date(), null, null);
    }
    /**
     * stores the attendance record entity
     */
    public abstract void markAttendance();

}
