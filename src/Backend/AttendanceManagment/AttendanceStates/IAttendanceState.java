package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceRecord;

import java.util.List;

public interface IAttendanceState {
    /**
     * stores the attendance record entity
     */
    void markAttendance(List<AttendanceRecord> attendanceRecords);
}
