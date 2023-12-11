package Backend.AttendanceManagment;

import Backend.AttendanceManagment.AttendanceStates.IAttendanceState;

import java.util.ArrayList;

public class AttendanceManager implements IAttendanceManager {

    private int employeeID;
    private ArrayList<AttendanceRecord> attendanceRecords;
    private IAttendanceState attendanceState;


    public void markAttendance() {

    }

    public void editAttendance(int ID, AttendanceRecord updatedRecord) {

    }

    public void viewAttendanceHistory() {

    }

    public void superViewAttendanceHistory(int ID) {

    }
}
