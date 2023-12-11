package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;

public class ViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    public ViewAttendanceHistory(IAttendanceManager attendanceManager) {
        this.attendanceManager = attendanceManager;
    }

    public void execute() {

    }
}
