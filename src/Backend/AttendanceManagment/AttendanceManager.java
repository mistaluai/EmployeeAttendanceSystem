package Backend.AttendanceManagment;

import Backend.AttendanceManagment.AttendanceStates.IAttendanceState;
import Utilities.DataHandling.AttendanceFileHandler;
import Utilities.DataHandling.IAttendanceDataHandler;

import java.util.List;

public class AttendanceManager implements IAttendanceManager {

    private int employeeID;
    private List<AttendanceRecord> attendanceRecords;
    private IAttendanceState attendanceState;


    public void markAttendance() {

    }

    public void editAttendance(int ID, AttendanceRecord updatedRecord) {

    }

    public String [][] viewAttendanceHistory() {

    }

    public String [][] superViewAttendanceHistory(int ID) {

    }
}