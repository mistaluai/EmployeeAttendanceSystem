package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;
import Utilities.UIHandling.SuperViewAttendanceWindow;

public class SuperViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    SuperViewAttendanceWindow window;
    int ID;
    public SuperViewAttendanceHistory(IAttendanceManager attendanceManager, int ID, SuperViewAttendanceWindow window) {
        this.attendanceManager = attendanceManager;
        this.ID = ID;
        this.window = window;
    }

    @Override
    public void execute() {
        attendanceManager.superViewAttendanceHistory(ID, window);
    }

}
