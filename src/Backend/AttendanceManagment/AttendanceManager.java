package Backend.AttendanceManagment;

import Backend.AttendanceManagment.AttendanceStates.IAttendanceState;
import Utilities.DataHandling.AttendanceFileHandler;
import Utilities.DataHandling.IAttendanceDataHandler;

import java.text.SimpleDateFormat;
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
        return superViewAttendanceHistory(employeeID);
    }

    public String [][] superViewAttendanceHistory(int ID) {
        IAttendanceDataHandler attendanceDataHandler = new AttendanceFileHandler();
        attendanceRecords = attendanceDataHandler.getRecords(ID);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String [][] records = new String[attendanceRecords.size()][3];
        for (int i = 0; i < attendanceRecords.size(); i++) {
            AttendanceRecord myRecord = attendanceRecords.get(i);
            records[i][0] = dateFormat.format(myRecord.getDate());
            records[i][1] = timeFormat.format(myRecord.getTimeIn());
            records[i][2] = timeFormat.format(myRecord.getTimeOut());
        }
        return records;
    }
}