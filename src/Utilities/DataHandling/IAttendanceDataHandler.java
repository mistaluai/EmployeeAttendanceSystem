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
     * updates the existing attendance records of an employee
     * @param ID: Target employee ID
     * @param updatedRecords: List of updated records
     */
    void editRecord(int ID, List<AttendanceRecord> updatedRecords);

}
