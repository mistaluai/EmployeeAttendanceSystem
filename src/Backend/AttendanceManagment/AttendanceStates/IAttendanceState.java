package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceRecord;

import java.util.ArrayList;

public interface IAttendanceState {
    /**
     * stores the attendance record entity
     */
    void markAttendance(ArrayList<AttendanceRecord> attendanceRecords);
}
