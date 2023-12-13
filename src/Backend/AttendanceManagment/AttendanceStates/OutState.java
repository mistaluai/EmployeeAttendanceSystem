package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;

import java.util.Date;

public class OutState extends AttendanceState {

    public OutState(AttendanceManager attendanceManager) {
        super(attendanceManager);
    }

    @Override
    public void markAttendance() {
        attendanceRecord.setTimeIn(new Date());
        attendanceManager.setAttendanceState(new InState(attendanceManager));
    }

}
