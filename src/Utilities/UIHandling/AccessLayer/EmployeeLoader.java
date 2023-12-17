package Utilities.UIHandling.AccessLayer;

import Backend.Entities.Employee;
import Backend.Entities.Supervisor;
import Utilities.DataHandling.AttendanceFileHandler;

public class EmployeeLoader implements IEmployeeLoader {
    /**
     * This method is used to decide if the object
     * should be created as an employee or a supervisor
     * based on the employee's data.
     * returns null if the ID wasn't found.
     * @param ID: target employee's ID
     * @return The object
     */
    @Override
    public Employee getEmployee(int ID) {
        String employeeType = new AttendanceFileHandler().readEmployeeData(ID)[5];
        if (Integer.parseInt(employeeType) == 1){
            return new Supervisor(ID);
        } else if (Integer.parseInt(employeeType) == 0) {
            return new Employee(ID);
        }
        return null;
    }
}
