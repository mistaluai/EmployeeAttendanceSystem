package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;

import java.util.Date;
import java.util.List;

public class OutState implements IAttendanceState {


    @Override
    public void markAttendance(List<AttendanceRecord> attendanceRecords, AttendanceManager attendanceManager) {

        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setTimeIn(new Date());
        attendanceRecords.add(attendanceRecord);
        attendanceManager.setAttendanceState(new InState());

    }

}
