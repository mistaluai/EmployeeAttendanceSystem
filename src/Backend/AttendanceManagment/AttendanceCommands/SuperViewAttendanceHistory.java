package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;
import DTO.DTO;

public class SuperViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    DTO records;
    int ID;
    public SuperViewAttendanceHistory(IAttendanceManager attendanceManager, int ID, DTO records) {
        this.attendanceManager = attendanceManager;
        this.ID = ID;
        this.records = records;
    }

    @Override
    public void execute() {
        attendanceManager.superViewAttendanceHistory(ID, records);
    }

}
