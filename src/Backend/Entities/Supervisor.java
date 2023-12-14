/**
 * Supervisor class represents an employee with supervisor privileges.
 * Extends the Employee class to inherit basic employee attributes and methods.
 */
package Backend.Entities;

import Backend.AttendanceManagment.AttendanceCommands.EditAttendance;
import Backend.AttendanceManagment.AttendanceCommands.IAttendanceCommand;
import Backend.AttendanceManagment.AttendanceCommands.SuperViewAttendanceHistory;
import Backend.AttendanceManagment.AttendanceRecord;

public class Supervisor extends Employee {

    /**
     * Constructor to create a Supervisor object.
     * @param id The unique identifier for the supervisor.
     */
    public Supervisor(int id){
        super(id);
    }

    @Override
    public boolean isSuperVisor() {
        return true;
    }

    /**
     * Method to edit attendance records for employees.
     * @param ID The employee ID whose attendance record needs to be edited.
     * @param updatedRecord The updated attendance record.
     */
    public void editAttendance(int ID, AttendanceRecord updatedRecord) {
        IAttendanceCommand editAttendanceCommand = new EditAttendance(getAttendanceManager(), ID, updatedRecord);
        editAttendanceCommand.execute();
    }

    /**
     * Method to view attendance history of employees.
     * @param ID The employee ID whose attendance history is to be viewed.
     */
    public void superViewAttendanceHistory(int ID, String[][] attendanceHistory) {
        IAttendanceCommand superViewAttendanceHistoryCommand = new SuperViewAttendanceHistory(getAttendanceManager(), ID, attendanceHistory);
        superViewAttendanceHistoryCommand.execute();
    }
}
