package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;

public class SuperViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    String[][] attendanceHistory;
    int ID;
    public SuperViewAttendanceHistory(IAttendanceManager attendanceManager, int ID, String[][] attendanceHistory) {
        this.attendanceManager = attendanceManager;
        this.ID = ID;
        this.attendanceHistory = attendanceHistory;
    }

    @Override
    public void execute() {
        attendanceManager.superViewAttendanceHistory(ID, attendanceHistory);
    }

}
