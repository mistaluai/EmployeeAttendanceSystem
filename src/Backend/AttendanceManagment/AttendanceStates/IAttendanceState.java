package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;

import java.util.List;

public interface IAttendanceState {

    /**
     * Marks attendance based on the current state, updating the provided list of attendance records,
     * and persists the changes through the provided attendance manager.
     *
     * @param attendanceRecords   The list of attendance records to be updated.
     * @param attendanceManager   The attendance manager responsible for handling attendance-related operations.
     */
    void markAttendance(List<AttendanceRecord> attendanceRecords, AttendanceManager attendanceManager);

}
