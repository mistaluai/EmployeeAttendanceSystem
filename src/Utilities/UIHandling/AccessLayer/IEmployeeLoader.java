package Utilities.UIHandling.AccessLayer;

import Backend.Entities.Employee;

public interface IEmployeeLoader {
    /**
     * returns Employee object with its ID
     * @param ID: target employee's ID
     * @return The employee object
     */
    Employee getEmployee(int ID);

}
