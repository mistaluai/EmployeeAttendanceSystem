package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;

import java.util.Date;

public class InState extends AttendanceState{

    public InState(AttendanceManager attendanceManager) {
        super(attendanceManager);
    }

    @Override
    public void markAttendance() {
        attendanceRecord.setTimeOut(new Date());
        attendanceManager.setAttendanceState(new OutState(attendanceManager));
    }

}
