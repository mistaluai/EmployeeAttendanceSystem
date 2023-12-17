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

    /**
     * Retrieves a 2D array of formatted attendance records for use in front-end tables.
     * Returns a "Not Found" array if no records are present.
     * @return A 2D array containing formatted attendance data.
     */
    public String[][] getAttendanceRecordsArray() {
        // If the list is empty return not found array.
        if (attendanceRecords.isEmpty()){
            return new String[][]{{"Not Found","Not Found","Not Found",}};
        }

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
