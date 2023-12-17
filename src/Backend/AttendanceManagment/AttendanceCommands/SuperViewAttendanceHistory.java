package Backend.AttendanceManagment.AttendanceCommands;

import Backend.AttendanceManagment.IAttendanceManager;
import DTO.DTO;

public class SuperViewAttendanceHistory implements IAttendanceCommand {
    IAttendanceManager attendanceManager;
    DTO records;
    int ID;

    /**
     * Constructor for SuperViewAttendanceHistory class.
     * @param attendanceManager The attendance manager responsible for handling attendance operations.
     * @param ID The unique identifier for the super view operation.
     * @param records The Data Transfer Object (DTO) containing records for super viewing attendance history.
     */
    public SuperViewAttendanceHistory(IAttendanceManager attendanceManager, int ID, DTO records) {
        this.attendanceManager = attendanceManager;
        this.ID = ID;
        this.records = records;
    }

    /**
     * Executes the command to super view attendance history.
     */
    @Override
    public void execute() {
        attendanceManager.superViewAttendanceHistory(ID, records);
    }

}
