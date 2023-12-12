package Utilities.DataHandling;

import Backend.AttendanceManagment.AttendanceRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AttendanceFileHandler implements IAttendanceDataHandler {

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String dataPath = "./data/";

    /**
     * This is a helper method that will be used in getRecords.
     * The method parses the attendance record from a string to
     * an attendance object.
     * @param attendanceRecord: String that contains the data
     * @return: AttendanceRecord Object
     */
    private AttendanceRecord parse(String attendanceRecord) {
        String[] dates = attendanceRecord.split(",");

        try {
            return new AttendanceRecord(SDF.parse(dates[0].trim()), SDF.parse(dates[1].trim()), SDF.parse(dates[2].trim()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method reads the CSV file from the data folder,
     * Then parses the data and stores it in a list and returns it.
     * @param ID: Target employee ID
     * @return List<AttendanceRecord>: A list of attendance records
     */
    @Override
    public List<AttendanceRecord> getRecords(int ID) {
        List<AttendanceRecord> temp = new ArrayList<>();

        try{
            FileReader fr = new FileReader(dataPath+ID+".csv");
            BufferedReader reader = new BufferedReader(fr);

            String line;
            while ((line = reader.readLine()) != null) {
                temp.add(parse(line));
            }

            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * This is a helper method that will be used in editRecords.
     * The method transforms the attendance record object into
     * a string to be stored in the CSV file.
     * @param record: An attendance record object.
     * @return: The formatted string
     */
    private String format(AttendanceRecord record) {
        String date = SDF.format(record.getDate());
        String timeIn = SDF.format(record.getTimeIn());
        String timeOut = SDF.format(record.getTimeOut());
        return date + ", " + timeIn + ", " + timeOut;
    }

    /**
     * Write the new list of attendance records to a CSV file
     * int the data folder with the ID of the employee as the name
     * @param ID: Target employee ID
     * @param updatedRecords: List of updated records
     */
    @Override
    public void editRecord(int ID, List<AttendanceRecord> updatedRecords) {

        try{
            FileWriter fw = new FileWriter(dataPath+ID+".csv");
            PrintWriter writer = new PrintWriter(fw);

            for (AttendanceRecord record: updatedRecords) {
                writer.println(format(record));
            }

            writer.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}