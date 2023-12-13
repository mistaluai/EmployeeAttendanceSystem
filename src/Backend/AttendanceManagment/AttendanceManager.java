package Backend.AttendanceManagment;

import Backend.AttendanceManagment.AttendanceStates.IAttendanceState;
import Backend.AttendanceManagment.AttendanceStates.InState;
import Backend.AttendanceManagment.AttendanceStates.OutState;
import Utilities.DataHandling.AttendanceFileHandler;
import Utilities.DataHandling.IAttendanceDataHandler;

import java.text.SimpleDateFormat;
import java.util.List;

public class AttendanceManager implements IAttendanceManager {

    private int employeeID;
    private List<AttendanceRecord> attendanceRecords;
    private IAttendanceState attendanceState;

    /**
     * The constructor uses the ID to get the read the records
     * and checks the if the state in or out.
     * @param ID
     */
    public AttendanceManager(int ID) {
        employeeID = ID;
        attendanceRecords = new AttendanceFileHandler().getRecords(ID);
        if (attendanceRecords.size() != 0){
            if (attendanceRecords.get(attendanceRecords.size() - 1) == null){
                attendanceState = new InState();
            }
        }else{
            attendanceState = new OutState();
        }
    }

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