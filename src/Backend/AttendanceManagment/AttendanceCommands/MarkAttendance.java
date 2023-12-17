package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;

public class MarkAttendance implements  IAttendanceCommand {
    IAttendanceManager attendanceManager;

    /**
     * Constructor for MarkAttendance class.
     * @param attendanceManager The attendance manager responsible for handling attendance operations.
     */
    public MarkAttendance(IAttendanceManager attendanceManager) {
        this.attendanceManager = attendanceManager;
    }

    /**
     * Executes the command to mark attendance.
     */
    public void execute() {
        attendanceManager.markAttendance();
    }
}
