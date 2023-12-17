package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.AttendanceRecord;
import Backend.AttendanceManagment.IAttendanceManager;

public class EditAttendance implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    int ID;
    AttendanceRecord updatedRecord;

    /**
     * Constructor for EditAttendance class.
     * @param attendanceManager The attendance manager responsible for handling attendance operations.
     * @param ID The unique identifier of the attendance record to be edited.
     * @param updatedRecord The updated attendance record containing modified information.
     */
    public EditAttendance(IAttendanceManager attendanceManager, int ID, AttendanceRecord updatedRecord)
    {
        this.attendanceManager = attendanceManager;
        this.ID = ID;
        this.updatedRecord = updatedRecord;
    }

    /**
     * Executes the command to edit an attendance record.
     */
    @Override
    public void execute() {
        attendanceManager.editAttendance(ID, updatedRecord);
    }
}
