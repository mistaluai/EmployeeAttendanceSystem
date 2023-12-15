package Backend.AttendanceManagment;

import DTO.DTO;

public interface IAttendanceManager {
    /**
     * stores the attendance record entity based on the state of the employee's attendance
     */
    void markAttendance();

    /**
     * updates an existing attendance record of an employee
     * @param ID: Target employee's ID
     * @param updatedRecord:  the updated record to replace the old record
     */
    void editAttendance(int ID, AttendanceRecord updatedRecord);

    /**
     * views the attendance history of the employee
     */
    void viewAttendanceHistory(DTO records);

    /**
     * views the attendance history of another employee
     * @param ID: Target employee's ID
     */
    void superViewAttendanceHistory(int ID, DTO records);
}
