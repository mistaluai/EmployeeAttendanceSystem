package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;
import Utilities.UIHandling.ViewAttendanceWindow;

public class ViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    ViewAttendanceWindow window;
    public ViewAttendanceHistory(IAttendanceManager attendanceManager, ViewAttendanceWindow window) {
        this.attendanceManager = attendanceManager;
        this.window = window;
    }

    public void execute() {
        attendanceManager.viewAttendanceHistory(window);
    }
}
