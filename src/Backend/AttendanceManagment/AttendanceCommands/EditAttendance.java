package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.AttendanceRecord;
import Backend.AttendanceManagment.IAttendanceManager;

public class EditAttendance implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    int ID;
    AttendanceRecord updatedRecord;
    public EditAttendance(IAttendanceManager attendanceManager, int ID, AttendanceRecord updatedRecord)
    {
        this.attendanceManager = attendanceManager;
        this.ID = ID;
        this.updatedRecord = updatedRecord;
    }

    @Override
    public void execute() {

    }
}
