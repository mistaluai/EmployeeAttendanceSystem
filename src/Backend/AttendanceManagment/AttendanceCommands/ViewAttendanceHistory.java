package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.IAttendanceManager;

public class ViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    int ID;
    public ViewAttendanceHistory(int ID) {
        this.attendanceManager = new AttendanceManager(ID);
        this.ID = ID;
    }

    @Override
    public void execute() {
        attendanceManager.superViewAttendanceHistory(ID);
    }

}
