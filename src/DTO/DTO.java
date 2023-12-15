package DTO;

import Backend.AttendanceManagment.AttendanceRecord;

import java.text.SimpleDateFormat;
import java.util.List;

public class DTO {
    private List<AttendanceRecord> attendanceRecords;

    public DTO(List<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public List<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(List<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public String[][] getAttendanceRecordsArray() {
        String[][] attendanceHistory = new String[attendanceRecords.size()][3];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

        for (int i = 0; i < attendanceRecords.size(); i++) {
            AttendanceRecord myRecord = attendanceRecords.get(i);
            if (myRecord.getDate() != null)
                attendanceHistory[i][0] = dateFormat.format(myRecord.getDate());
            if (myRecord.getTimeIn() != null)
                attendanceHistory[i][1] = timeFormat.format(myRecord.getTimeIn());
            if (myRecord.getTimeOut() != null)
                attendanceHistory[i][2] = timeFormat.format(myRecord.getTimeOut());
        }

        return attendanceHistory;
    }
}
