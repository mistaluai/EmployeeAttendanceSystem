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

    public int getEmployeeID() {
        return employeeID;
    }

    public ArrayList<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public IAttendanceState getAttendanceState() {
        return attendanceState;
    }

    public void markAttendance() {
        attendanceState.markAttendance(attendanceRecords);
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setAttendanceRecords(ArrayList<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public void setAttendanceState(IAttendanceState attendanceState) {
        this.attendanceState = attendanceState;
    }

    public void editAttendance(int ID, AttendanceRecord updatedRecord) {
        for (int i = 0; i < attendanceRecords.size(); i++) {
            if (updatedRecord.getDate().getYear() == attendanceRecords.get(i).getDate().getYear() &&
                updatedRecord.getDate().getMonth() == attendanceRecords.get(i).getDate().getMonth() &&
                updatedRecord.getDate().getDay() == attendanceRecords.get(i).getDate().getDay()) {
                attendanceRecords.set(i, updatedRecord);
                break;
            }
        }
    }

    public void viewAttendanceHistory() {

    }

    public void superViewAttendanceHistory(int ID) {

    }

}
