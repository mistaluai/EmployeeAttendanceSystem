package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceRecord;

import java.util.ArrayList;
import java.util.Date;

public class InState implements IAttendanceState{

    @Override
    public void markAttendance(ArrayList<AttendanceRecord> attendanceRecords) {

        attendanceRecords.get(-1).setTimeOut(new Date());

    }

}
