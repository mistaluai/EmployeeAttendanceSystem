package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;
import DTO.DTO;

public class ViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    DTO records;
    public ViewAttendanceHistory(IAttendanceManager attendanceManager, DTO records) {
        this.attendanceManager = attendanceManager;
        this.records = records;
    }

    public void execute() {
        attendanceManager.viewAttendanceHistory(records);
    }
}
