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
     * This method is used to return a 2D array of
     * the attendance records to be used in the front end tables.
     * It returns not found if there is no records.
     * @return: 2D array of the data
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
            attendanceHistory[i][0] = dateFormat.format(myRecord.getDate());
            attendanceHistory[i][1] = timeFormat.format(myRecord.getTimeIn());
            attendanceHistory[i][2] = timeFormat.format(myRecord.getTimeOut());
        }

        return attendanceHistory;
    }
}
