package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;

import java.util.Date;

public class OutState extends AttendanceState {

    public OutState(AttendanceManager attendanceManager) {
        super(attendanceManager);
        attendanceRecord = new AttendanceRecord(new Date(), null, null);
    }

    @Override
    public void markAttendance() {
        attendanceRecord.setTimeIn(new Date());
        attendanceManager.setAttendanceState(new InState(attendanceManager));
    }

}
