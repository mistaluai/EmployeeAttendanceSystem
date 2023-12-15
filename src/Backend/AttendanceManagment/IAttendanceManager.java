package Backend.AttendanceManagment;

import Utilities.UIHandling.SuperViewAttendanceWindow;
import Utilities.UIHandling.ViewAttendanceWindow;

public interface IAttendanceManager {
    /**
     * Stores the attendance record entity based on the state of the employee's attendance.
     */
    void markAttendance();

    /**
     * updates an existing attendance record of an employee.
     *
     * @param ID              Target employee's ID.
     * @param updatedRecord   The updated record to replace the old record.
     */
    void editAttendance(int ID, AttendanceRecord updatedRecord);

    /**
     * Views the attendance history of the employee.
     */
    void viewAttendanceHistory(ViewAttendanceWindow window);

    /**
     * Views the attendance history of another employee
     *
     * @param ID   Target employee's ID.
     */
    void superViewAttendanceHistory(int ID, SuperViewAttendanceWindow window);
}
