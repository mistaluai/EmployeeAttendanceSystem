package Backend.Entities;

import Backend.AttendanceManagment.AttendanceCommands.IAttendanceCommand;
import Backend.AttendanceManagment.AttendanceCommands.MarkAttendance;
import Backend.AttendanceManagment.AttendanceCommands.ViewAttendanceHistory;
import Backend.AttendanceManagment.AttendanceManager;
    /**
     * This class represents an Employee in the company.
     */
public class Employee {
    // Employee attributes
    private final String name, position;
    private final int id;
    private final Department department;
    private final AttendanceManager attendanceManager;

    /**
     * Constructor for creating an Employee object.
     * @param name The name of the employee.
     * @param id The unique identifier of the employee.
     * @param position The position/title of the employee.
     * @param department The department the employee belongs to.
     */
    public Employee(String name, int id, String position, Department department) {
        this.name = name;
        this.position = position;
        this.id = id;
        this.department = department;
        attendanceManager = new AttendanceManager();
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


    /**
     * Mark the attendance for the employee.
     */
    public void markAttendance() {
        IAttendanceCommand markAttendanceCommand = new MarkAttendance(getAttendanceManager());
        markAttendanceCommand.execute();
    }


    /**
     * View the attendance history of the employee.
     */
    public void viewAttendanceHistory() {
        IAttendanceCommand viewAttendanceHistoryCommand = new ViewAttendanceHistory(getAttendanceManager());
        viewAttendanceHistoryCommand.execute();
    }
}