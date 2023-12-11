package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceRecord;

public interface IAttendanceState {
    /**
     * stores the attendance record entity
     */
    AttendanceRecord markAttendance(AttendanceRecord attendanceRecord);
}
