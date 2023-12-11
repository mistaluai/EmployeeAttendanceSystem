package Utilities.DataHandling;

import Backend.AttendanceManagment.AttendanceRecord;

import java.util.List;

public interface IAttendanceDataHandler {
    /**
     * Reads the employee attendance record data
     * @param ID: Target employee ID
     * @return: returns list of attendance records
     */
    List<AttendanceRecord> getRecords(int ID);

    /**
     * updates an existing attendance record of an employee
     * @param ID: Target employee ID
     * @param updatedRecord: the updated record to replace the old record
     */
    void editRecord(int ID, AttendanceRecord updatedRecord);

}
