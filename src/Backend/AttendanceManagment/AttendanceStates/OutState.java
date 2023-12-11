package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceRecord;

import java.util.Date;

public class OutState implements IAttendanceState {

    @Override
    public AttendanceRecord markAttendance(AttendanceRecord attendanceRecord) {

        attendanceRecord.setTimeOut(new Date());
        return attendanceRecord;

    }

}
