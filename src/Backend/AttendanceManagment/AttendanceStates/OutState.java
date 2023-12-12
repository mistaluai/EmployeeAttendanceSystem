package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceRecord;

import java.util.ArrayList;
import java.util.Date;

public class OutState implements IAttendanceState {


    @Override
    public void markAttendance(ArrayList<AttendanceRecord> attendanceRecords) {

        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setTimeIn(new Date());
        attendanceRecords.add(attendanceRecord);

    }

}
