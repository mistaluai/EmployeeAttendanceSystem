package Backend.AttendanceManagment.AttendanceStates;

import Backend.AttendanceManagment.AttendanceManager;
import Backend.AttendanceManagment.AttendanceRecord;

import java.util.Date;
import java.util.List;

public class InState implements IAttendanceState{

    @Override
    public void markAttendance(List<AttendanceRecord> attendanceRecords, AttendanceManager attendanceManager) {

        attendanceRecords.get(attendanceRecords.size() - 1).setTimeOut(new Date());
        attendanceManager.setAttendanceState(new OutState());

    }

}
