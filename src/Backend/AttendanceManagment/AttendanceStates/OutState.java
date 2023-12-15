package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;

import java.util.Date;
import java.util.List;

public class OutState implements IAttendanceState {

    /**
     * Marks attendance for the current state, updating the provided list of attendance records.
     * Creates a new attendance record with the current time as the clock-in time,
     * adds it to the list of attendance records, and transitions the attendance manager
     * to the 'InState' to reflect the employee being in the office.
     *
     * @param attendanceRecords   The list of attendance records to be updated.
     * @param attendanceManager   The attendance manager responsible for handling attendance-related operations.
     */
    @Override
    public void markAttendance(List<AttendanceRecord> attendanceRecords, AttendanceManager attendanceManager) {
        // Creates a new attendance record with the current time as the clock-in time.
        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setTimeIn(new Date());

        // Adds the new attendance record to the list of attendance records.
        attendanceRecords.add(attendanceRecord);

        // Transitions the attendance manager to the 'InState' to reflect the employee being in the office.
        attendanceManager.setAttendanceState(new InState());
    }

}
