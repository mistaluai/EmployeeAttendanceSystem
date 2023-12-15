package Backend.AttendanceManagment;

import Backend.AttendanceManagment.AttendanceStates.IAttendanceState;
import Backend.AttendanceManagment.AttendanceStates.InState;
import Backend.AttendanceManagment.AttendanceStates.OutState;
import Utilities.DataHandling.AttendanceFileHandler;
import Utilities.DataHandling.IAttendanceDataHandler;
import DTO.DTO;
import java.text.SimpleDateFormat;
import java.util.List;

public class AttendanceManager implements IAttendanceManager {

    private final int employeeID;
    private List<AttendanceRecord> attendanceRecords;
    private IAttendanceState attendanceState;

    /**
     * Initializes a new instance of the AttendanceManager class for a specific employee ID.
     * Retrieves attendance records for the employee from a data source.
     *
     * @param ID   The employee ID.
     */
    public AttendanceManager(int ID) {
        employeeID = ID;
        attendanceRecords = new AttendanceFileHandler().getRecords(ID);
    }

    /**
     * Checks the last attendance record to determine the current attendance state (In or Out).
     */
    private void checkRecords() {
        if (!attendanceRecords.isEmpty() && attendanceRecords.get(attendanceRecords.size() - 1).getTimeOut() == null)
            attendanceState = new InState();
        else
            attendanceState = new OutState();
    }

    /**
     * Sets the current attendance state.
     *
     * @param attendanceState   The attendance state to set.
     */
    public void setAttendanceState(IAttendanceState attendanceState) {
        this.attendanceState = attendanceState;
    }

    /**
     * Marks attendance for the employee, updating the attendance records based on the current state,
     * and persists the changes by editing the records through an AttendanceFileHandler.
     * This method is typically called when an employee either clocks in or clocks out.
     */
    public void markAttendance() {
        // Checks the current state and updates the attendance records accordingly.
        checkRecords();

        // Delegates the marking of attendance to the current attendance state.
        attendanceState.markAttendance(attendanceRecords, this);

        // Persists the changes by editing the attendance records through an AttendanceFileHandler.
        new AttendanceFileHandler().editRecord(employeeID, attendanceRecords);
    }

    /**
     * Edits a specific attendance record for the given employee ID with updated information.
     * Retrieves the existing attendance records, searches for the record with the same date as the updated record,
     * replaces it with the updated record, and persists the changes through an AttendanceFileHandler.
     *
     * @param ID               The employee ID.
     * @param updatedRecord    The updated attendance record.
     */
    public void editAttendance(int ID, AttendanceRecord updatedRecord) {
        // Create an instance of AttendanceFileHandler to handle file operations.
        AttendanceFileHandler fileHandler = new AttendanceFileHandler();

        // Retrieve the existing attendance records for the specified employee ID.
        List<AttendanceRecord> updatedAttendanceRecords = fileHandler.getRecords(ID);

        // Format the date of the updated record to match the format used in the existing records.
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String updatedDate = formatter.format(updatedRecord.getDate());

        // Iterate through the existing records to find and replace the record with the same date as the updated record.
        String existedDate;
        for (int i = 0; i < updatedAttendanceRecords.size(); i++) {
            existedDate = formatter.format(updatedAttendanceRecords.get(i).getDate());
            if (updatedDate.equals(existedDate)) {
                updatedAttendanceRecords.set(i, updatedRecord);
                break;
            }
        }

        // Persist the changes by editing the attendance records through an AttendanceFileHandler.
        fileHandler.editRecord(ID, updatedAttendanceRecords);
    }

    /**
     * Retrieves attendance records for the current employee and sets them in the provided DTO.
     * Commonly used by the employee.
     *
     * @param records The DTO (Data Transfer Object) to store the retrieved attendance records.
     */
    public void viewAttendanceHistory(DTO records) {
        // Call the superViewAttendanceHistory method with the current employee's ID and the provided DTO.
        superViewAttendanceHistory(employeeID, records);
    }

    /**
     * Retrieves attendance records for any employee with the specified ID
     * and sets the attendance records in the provided DTO.
     * Commonly used by the supervisor.
     *
     * @param ID      The employee ID for whom the attendance records are retrieved.
     * @param records The DTO (Data Transfer Object) to store the retrieved attendance records.
     */
    public void superViewAttendanceHistory(int ID, DTO records) {
        // Create an instance of IAttendanceDataHandler to handle data retrieval.
        IAttendanceDataHandler attendanceDataHandler = new AttendanceFileHandler();

        // Retrieve the attendance records for the specified employee ID.
        attendanceRecords = attendanceDataHandler.getRecords(ID);

        // Set the retrieved attendance records in the provided DTO.
        records.setAttendanceRecords(attendanceRecords);
    }

    /**
     * Returns the attendance state of the employee
     * @return true if the employee was out of the company, false if he was in the company
     */
    public boolean getState() {
        if (attendanceState instanceof InState)
            return false;
        return true;
    }

}
