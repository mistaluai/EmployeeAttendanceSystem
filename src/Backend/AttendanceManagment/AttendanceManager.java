package Backend.AttendanceManagment;

import Backend.AttendanceManagment.AttendanceStates.IAttendanceState;

import java.util.ArrayList;

public class AttendanceManager implements IAttendanceManager {

    private int employeeID;
    private ArrayList<AttendanceRecord> attendanceRecords;
    private IAttendanceState attendanceState;

    public AttendanceManager(int employeeID, ArrayList<AttendanceRecord> attendanceRecords, IAttendanceState attendanceState) {
        this.employeeID = employeeID;
        this.attendanceRecords = attendanceRecords;
        this.attendanceState = attendanceState;
    }

    public void markAttendance() {
        attendanceState.markAttendance(attendanceRecords);
    }

    public void editAttendance(int ID, AttendanceRecord updatedRecord) {
        for (int i = 0; i < attendanceRecords.size(); i++) {
            if (attendanceRecords.get(i).getDate() == updatedRecord.getDate()) {
                attendanceRecords.set(i, updatedRecord);
                break;
            }
        }
    }

    public void viewAttendanceHistory() {
        superViewAttendanceHistory(this.employeeID);
    }

    public void superViewAttendanceHistory(int ID) {
        System.out.println("Date\t\tTime In\t\tTime Out\n" +
                           "-----------------------------");
        for (AttendanceRecord record : attendanceRecords) {
            System.out.println(record.getDate() + "\t\t" + record.getTimeIn() + "\t\t" + record.getTimeOut());
        }
    }
}
