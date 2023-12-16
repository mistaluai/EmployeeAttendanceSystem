package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;
import Utilities.Logging.Logger;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InState implements IAttendanceState{

    /**
     * Marks attendance for the current state, updating the provided list of attendance records.
     * Sets the clock-out time for the last attendance record and transitions the attendance manager
     * to the 'OutState' to reflect the employee being out of the office.
     *
     * @param attendanceRecords   The list of attendance records to be updated.
     * @param attendanceManager   The attendance manager responsible for handling attendance-related operations.
     */
    @Override
    public void markAttendance(List<AttendanceRecord> attendanceRecords, AttendanceManager attendanceManager) {
        // Using try catch for Logging
        try{
            // Sets the clock-out time for the last attendance record in the list to the current time.
            attendanceRecords.get(attendanceRecords.size() - 1).setTimeOut(new Date());

            // Transitions the attendance manager to the 'OutState' to reflect the employee being out of the office.
            attendanceManager.setAttendanceState(new OutState());

            // Writing logs
            new Logger().writeLog("Employee ID " + attendanceManager.getEmployeeID() + " checked out.");

        }catch (Exception e){
            // Logging the errors
            new Logger().writeError(Arrays.toString(e.getStackTrace()));
        }

    }

}
