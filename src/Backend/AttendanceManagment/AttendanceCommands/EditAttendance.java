package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;
import Backend.AttendanceManagment.IAttendanceManager;

public class EditAttendance implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    int ID;
    AttendanceRecord updatedRecord;
    public EditAttendance(int ID, AttendanceRecord updatedRecord)
    {
        this.attendanceManager = new AttendanceManager(ID);
        this.ID = ID;
        this.updatedRecord = updatedRecord;
    }

    @Override
    public void execute() {
        attendanceManager.editAttendance(ID, updatedRecord);
    }
}
