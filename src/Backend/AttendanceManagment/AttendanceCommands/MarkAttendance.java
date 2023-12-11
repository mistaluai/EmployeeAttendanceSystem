package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;

public class MarkAttendance implements  IAttendanceCommand {
    IAttendanceManager attendanceManager;
    public MarkAttendance(IAttendanceManager attendanceManager) {
        this.attendanceManager = attendanceManager;
    }

    public void execute() {

    }
}
