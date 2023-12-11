package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceRecord;

import java.util.Date;

public class InState implements IAttendanceState{

    @Override
    public AttendanceRecord markAttendance(AttendanceRecord attendanceRecord) {

        attendanceRecord.setTimeIn(new Date());
        return attendanceRecord;

    }

}
