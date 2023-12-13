package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceRecord;

import java.util.Date;
import java.util.List;

public class InState implements IAttendanceState{

    @Override
    public void markAttendance(List<AttendanceRecord> attendanceRecords) {

        attendanceRecords.get(-1).setTimeOut(new Date());

    }

}
