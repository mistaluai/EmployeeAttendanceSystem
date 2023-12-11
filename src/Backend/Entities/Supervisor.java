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
     * @param name The name of the supervisor.
     * @param id The unique identifier for the supervisor.
     * @param position The job position of the supervisor.
     * @param department The department to which the supervisor belongs.
     */
    public Supervisor(String name, int id, String position, Department department) {
        super(name, id, position, department);
    }

    /**
     * Method to edit attendance records for employees.
     * @param ID The employee ID whose attendance record needs to be edited.
     * @param updatedRecord The updated attendance record.
     */
    public void editAttendance(int ID, AttendanceRecord updatedRecord) {
        IAttendanceCommand editAttendanceCommand = new EditAttendance(getAttendanceManager(), getId(), updatedRecord);
        editAttendanceCommand.execute();
    }

    /**
     * Method to view attendance history of employees.
     * @param ID The employee ID whose attendance history is to be viewed.
     */
    public void superViewAttendanceHistory(int ID) {
        IAttendanceCommand superViewAttendanceHistoryCommand = new SuperViewAttendanceHistory(getAttendanceManager(), getId());
    }
}