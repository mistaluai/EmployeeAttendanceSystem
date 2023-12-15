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

    private int employeeID;
    private List<AttendanceRecord> attendanceRecords;
    private IAttendanceState attendanceState;

    public void setAttendanceState(IAttendanceState attendanceState) {
        this.attendanceState = attendanceState;
    }

    /**
     * The constructor uses the ID to get the read the records
     * and checks the if the state in or out.
     * @param ID
     */
    public AttendanceManager(int ID) {
        employeeID = ID;
        attendanceRecords = new AttendanceFileHandler().getRecords(ID);
        if (attendanceRecords.size() != 0){
            if (attendanceRecords.get(attendanceRecords.size() - 1).getTimeOut() == null){
                attendanceState = new InState();
            }
        }else{
            attendanceState = new OutState();
        }
    }


    public void markAttendance() {
        attendanceState.markAttendance(attendanceRecords, this);
        new AttendanceFileHandler().editRecord(employeeID, attendanceRecords);
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
