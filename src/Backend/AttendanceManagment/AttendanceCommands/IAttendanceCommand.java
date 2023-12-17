package Backend.AttendanceManagment.AttendanceCommands;

public interface IAttendanceCommand {

    /**
     * Executes the specific attendance command.
     * Unified method for all the methods that implements the interface.
     */
    void execute();
}
