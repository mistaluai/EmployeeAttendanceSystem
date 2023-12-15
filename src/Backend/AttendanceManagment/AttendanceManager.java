package Backend.AttendanceManagment;

import Backend.AttendanceManagment.AttendanceStates.IAttendanceState;
import Backend.AttendanceManagment.AttendanceStates.InState;
import Backend.AttendanceManagment.AttendanceStates.OutState;
import Utilities.DataHandling.AttendanceFileHandler;
import Utilities.DataHandling.IAttendanceDataHandler;
import Utilities.UIHandling.SuperViewAttendanceWindow;
import Utilities.UIHandling.ViewAttendanceWindow;

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
        if (!attendanceRecords.isEmpty() && attendanceRecords.getLast().getTimeOut() == null)
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


    public void viewAttendanceHistory(ViewAttendanceWindow window) {
        IAttendanceDataHandler attendanceDataHandler = new AttendanceFileHandler();
        attendanceRecords = attendanceDataHandler.getRecords(employeeID);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        window.attendanceHistory = new String[attendanceRecords.size()][3];
        if (attendanceRecords.size() == 0)
            window.attendanceHistory = new String[][] {{"Not Found", "Not Found", "Not Found"}};
        else
            for (int i = 0; i < attendanceRecords.size(); i++) {
                AttendanceRecord myRecord = attendanceRecords.get(i);
                window.attendanceHistory[i][0] = dateFormat.format(myRecord.getDate());
                window.attendanceHistory[i][1] = timeFormat.format(myRecord.getTimeIn());
                window.attendanceHistory[i][2] = timeFormat.format(myRecord.getTimeOut());
            }
    }

    public void superViewAttendanceHistory(int ID, SuperViewAttendanceWindow window) {
        IAttendanceDataHandler attendanceDataHandler = new AttendanceFileHandler();
        attendanceRecords = attendanceDataHandler.getRecords(ID);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        window.attendanceHistory = new String[attendanceRecords.size()][3];
        if (attendanceRecords.size() == 0)
            window.attendanceHistory = new String[][] {{"Not Found", "Not Found", "Not Found"}};
        else
            for (int i = 0; i < attendanceRecords.size(); i++) {
                AttendanceRecord myRecord = attendanceRecords.get(i);
                window.attendanceHistory[i][0] = dateFormat.format(myRecord.getDate());
                window.attendanceHistory[i][1] = timeFormat.format(myRecord.getTimeIn());
                window.attendanceHistory[i][2] = timeFormat.format(myRecord.getTimeOut());
            }
    }
}
