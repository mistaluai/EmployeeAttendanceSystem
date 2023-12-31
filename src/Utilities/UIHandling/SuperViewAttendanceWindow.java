package Utilities.UIHandling;

import Backend.Entities.Employee;
import Backend.Entities.Supervisor;
import DTO.DTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SuperViewAttendanceWindow extends JFrame {

    /**
     * Object of type Supervisor.
     */
    private Supervisor supervisorProfile;
    /**
     * Object of type the SupervisorWindow window to access it.
     */
    private SupervisorWindow supervisorWindow;
    /**
     * Two-dimensional array
     * The data matrix that will be shown in the table
     */
    public String[][] attendanceHistory;

    /**
     * Constructor
     * @param supervisorWindow Object of type Supervisor.
     * @param supervisorProfile Object of type the SupervisorWindow window.
     * @param ID Target employee's ID.
     */
    public SuperViewAttendanceWindow(SupervisorWindow supervisorWindow,
                                     Employee supervisorProfile, int ID) {
        //set the supervisor profile to access his data
        this.supervisorProfile = (Supervisor) supervisorProfile;
        //set the profile window to access it if we wanted to go back
        this.supervisorWindow = supervisorWindow;

        //Sets title of the window
        setTitle("Attendance History of Employee " + ID);
        //sets the size of the window
        setSize(400, 300);
        setMinimumSize(new Dimension(400, 300));
        setMaximumSize(new Dimension(400, 300));

        //set its position to center the screen
        setLocationRelativeTo(null);

        // create a global font to be used by the components
        Font globalFontBold = new Font("Lucida Grande", Font.BOLD, 13);
        Font globalFont = new Font("Lucida Grande", Font.PLAIN, 13);

        // Using the DTO
        DTO records = new DTO(null);

        //initialize the data that will be shown
        this.supervisorProfile.superViewAttendanceHistory(ID, records);

        //Getting the 2D array for the table
        String[][] attendanceHistory = records.getAttendanceRecordsArray();

        /*test driver start
        String[][] attendanceHistory = {
                {"12/12/2023", "11:27:44", "11:27:44"},
                {"12/12/2023", "11:27:44", "11:27:44"},
                {"12/12/2023", "11:27:44", "11:27:44"}
        };
        //test driver end*/
        String[] titles = {"Date", "Time in", "Time out"};

        //initialize the table using the given data
        JTable attendaceHistoryTable = new JTable(attendanceHistory, titles) {
            //overriding this method
            // to make sure that all cells are not editable,
            // to make the table read only
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        attendaceHistoryTable.setBounds(0,0, 400, 300);
        //change its font
        attendaceHistoryTable.setFont(globalFontBold);


        //initialize a scroll panel to allow navigation through the table
        JScrollPane tableContainer = new JScrollPane(attendaceHistoryTable);

        //add the panel to the frame
        add(tableContainer);

        //show the window
        setVisible(true);

        //add action listener to the window to go back to the supervisor window
        // when this one gets closed
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is being closed.
             * sets the visibility of the previous page to be true
             * @param e
             */
            public void windowClosing(WindowEvent e) {
                supervisorWindow.setVisible(true);
            }
        });
    }

}
