package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;
import DTO.DTO;

public class ViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    DTO records;

    /**
     * Constructor for ViewAttendanceHistory class.
     * @param attendanceManager The attendance manager responsible for handling attendance operations.
     * @param records The Data Transfer Object (DTO) containing records for viewing attendance history.
     */
    public ViewAttendanceHistory(IAttendanceManager attendanceManager, DTO records) {
        this.attendanceManager = attendanceManager;
        this.records = records;
    }

    /**
     * Executes the command to view attendance history.
     */
    public void execute() {
        attendanceManager.viewAttendanceHistory(records);
    }
}
