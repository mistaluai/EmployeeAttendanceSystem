package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;

public abstract class AttendanceState {

    protected AttendanceManager attendanceManager;
    protected AttendanceRecord attendanceRecord;
    public AttendanceState(AttendanceManager attendanceManager) {
        this.attendanceManager = attendanceManager;
    }
    /**
     * stores the attendance record entity
     */
    public abstract void markAttendance();

}
