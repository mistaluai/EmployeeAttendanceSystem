package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;

public class SuperViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    int ID;
    public SuperViewAttendanceHistory(IAttendanceManager attendanceManager, int ID) {
        this.attendanceManager = attendanceManager;
        this.ID = ID;
    }

    @Override
    public void execute() {

    }

}
