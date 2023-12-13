package Backend.AttendanceManagment;

import Backend.AttendanceManagment.AttendanceStates.AttendanceState;
import Utilities.DataHandling.AttendanceFileHandler;
import Utilities.DataHandling.IAttendanceDataHandler;
import java.text.SimpleDateFormat;
import java.util.List;

public class AttendanceManager implements IAttendanceManager {

    private int employeeID;
    private List<AttendanceRecord> attendanceRecords;
    private AttendanceState attendanceState;

    public AttendanceManager(int employeeID) {
        this.employeeID = employeeID;
        attendanceRecords = new AttendanceFileHandler().getRecords(employeeID);
    }

    public void setAttendanceState(AttendanceState attendanceState) {
        this.attendanceState = attendanceState;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public List<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public AttendanceState getAttendanceState() {
        return attendanceState;
    }

    public void markAttendance() {

    }

    public void editAttendance(int ID, AttendanceRecord updatedRecord) {
        AttendanceFileHandler fileHandler = new AttendanceFileHandler();
        List<AttendanceRecord> updatedAttendanceRecords = fileHandler.getRecords(ID);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String updatedDate = formatter.format(updatedRecord.getDate());
        String existedDate;
        for (int i = 0; i < updatedAttendanceRecords.size(); i++) {
            existedDate = formatter.format(updatedAttendanceRecords.get(i).getDate());
            if (updatedDate.equals(existedDate)) {
                updatedAttendanceRecords.set(i, updatedRecord);
                break;
            }
        }
        fileHandler.editRecord(ID, updatedAttendanceRecords);
    }

    public String[][] viewAttendanceHistory() {
        return superViewAttendanceHistory(employeeID);
    }

    public String[][] superViewAttendanceHistory(int ID) {
        IAttendanceDataHandler attendanceDataHandler = new AttendanceFileHandler();
        attendanceRecords = attendanceDataHandler.getRecords(ID);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String[][] records = new String[attendanceRecords.size()][3];
        for (int i = 0; i < attendanceRecords.size(); i++) {
            AttendanceRecord myRecord = attendanceRecords.get(i);
            records[i][0] = dateFormat.format(myRecord.getDate());
            records[i][1] = timeFormat.format(myRecord.getTimeIn());
            records[i][2] = timeFormat.format(myRecord.getTimeOut());
        }
        return records;
    }

}
