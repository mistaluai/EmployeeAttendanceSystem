package Utilities.DataHandling;

import Backend.AttendanceManagment.AttendanceRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceFileHandler implements IAttendanceDataHandler {

    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final String dataPath = "./data/";

    /**
     * This is a helper method that will be used in getRecords.
     * The method parses the attendance record from a string to
     * an attendance object.
     * If it reads "-1" it sets the dates to null
     * @param attendanceRecord: String that contains the data
     * @return: AttendanceRecord Object
     */
    private AttendanceRecord parse(String attendanceRecord) {
        String[] dates = attendanceRecord.split(",");

        Date date = null, timeIn = null, timeOut = null;

        try {
            if (!dates[0].trim().equals("-1")){
                date = SDF.parse(dates[0].trim());}
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            if (!dates[1].trim().equals("-1")){
                timeIn = SDF.parse(dates[1].trim());}
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            if (!dates[2].trim().equals("-1")){
                timeOut = SDF.parse(dates[2].trim());}
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new AttendanceRecord(date, timeIn, timeOut);
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
     * If the date is null it's recorded as "-1"
     * @param record: An attendance record object.
     * @return: The formatted string
     */
    private String format(AttendanceRecord record) {
        String date = "-1", timeIn = "-1", timeOut = "-1";

        if (record.getDate() != null){
            date = SDF.format(record.getDate());}
        if (record.getTimeIn() != null){
            timeIn = SDF.format(record.getTimeIn());}
        if (record.getTimeOut() != null){
            timeOut = SDF.format(record.getTimeOut());}

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

    /**
     * This is a helper method used in readEmployeeData, It
     * trims the spaces before the data when reading it.
     * @param employeeData: The array of data after reading it.
     */
    private void trim(String[] employeeData){
        for (int i = 0; i < employeeData.length; i++) {
            employeeData[i] = employeeData[i].trim();
        }
    }

    /**
     * This method extracts the employee data from the data.csv
     * file in the data folder and returns an array of string
     * representing the employee data.
     * @param ID: The id of the employee.
     * @return String[] employeeData: The array of the employee data.
     */
    @Override
    public String[] readEmployeeData(int ID) {
        String[] employeeData = new String[6];

        try{
            FileReader fr = new FileReader(dataPath + "data.csv");
            BufferedReader reader = new BufferedReader(fr);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == ID){
                    employeeData = data;
                    trim(employeeData);
                    break;
                }
            }

            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeData;
    }
}