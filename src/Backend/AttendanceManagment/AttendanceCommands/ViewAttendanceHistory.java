package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;

public class ViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    String[][] attendanceHistory;
    public ViewAttendanceHistory(IAttendanceManager attendanceManager, String[][] attendanceHistory) {
        this.attendanceManager = attendanceManager;
        this.attendanceHistory = attendanceHistory;
    }

    public void execute() {
        attendanceManager.viewAttendanceHistory(attendanceHistory);
    }
}
