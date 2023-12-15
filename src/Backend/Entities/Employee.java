package Backend.Entities;

import Backend.AttendanceManagment.AttendanceCommands.IAttendanceCommand;
import Backend.AttendanceManagment.AttendanceCommands.MarkAttendance;
import Backend.AttendanceManagment.AttendanceCommands.ViewAttendanceHistory;
import Backend.AttendanceManagment.AttendanceManager;
import Utilities.DataHandling.AttendanceFileHandler;
import Utilities.UIHandling.ViewAttendanceWindow;

/**
* This class represents an Employee in the company.
*/
public class Employee {

    // Employee attributes
    private final String name;
    private final String position;
    private final int id;
    private final Department department;
    private final AttendanceManager attendanceManager;
    protected IAttendanceCommand command;

    public Employee(int id) {
        this.id = id;
        attendanceManager = new AttendanceManager(id);
        String [] attributes = new AttendanceFileHandler().readEmployeeData(id);
        this.name = attributes[1];
        this.position = attributes[2];
        this.department = new Department(attributes[3], attributes[4]);
    }

    public boolean isSuperVisor(){
        return false;
    }

     /**
     * Get the name of the employee.
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the position/title of the employee.
     * @return The position of the employee.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Get the unique identifier of the employee.
     * @return The ID of the employee.
     */
    public int getId() {
        return id;
    }

    /**
     * Get the department the employee belongs to.
     * @return The department of the employee.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Get the attendance manager for the employee.
     * @return The attendance manager object.
     */
    public AttendanceManager getAttendanceManager() {
        return attendanceManager;
    }

    public void setCommand(IAttendanceCommand command) {
        this.command = command;
    }

    /**
     * Mark the attendance for the employee.
     */
    public void markAttendance() {
        setCommand(new MarkAttendance(attendanceManager));
        command.execute();
    }

    /**
     * View the attendance history of the employee.
     */
    public void viewAttendanceHistory(ViewAttendanceWindow window) {
        setCommand(new ViewAttendanceHistory(getAttendanceManager(), window));
        command.execute();
    }
}