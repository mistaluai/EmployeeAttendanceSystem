package Utilities.UIHandling;

import Backend.Entities.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeProfileWindow extends JFrame {
    /**
     * Object of type Employee.
     */
    Employee employeeProfile;
    /**
     * Object of type the LandingWindow window to access it.
     */
    LandingWindow landingWindow;

    /**
     * Constructor
     * @param landingWindow Object of type the LandingWindow window
     *                      to access it.
     * @param employeeProfile  Object of type Employee.
     */
    public EmployeeProfileWindow(LandingWindow landingWindow,
                                 Employee employeeProfile) {
        //set the employee profile to access his data
        this.employeeProfile = employeeProfile;
        //set the landing window to access it if we wanted to go back
        this.landingWindow = landingWindow;

        //Sets title of the window
        setTitle("Employee's Profile");
        //sets the size of the window
        setSize(400, 300);
        setMinimumSize(new Dimension(400, 300));
        setMaximumSize(new Dimension(400, 300));

        //set its position to center the screen
        setLocationRelativeTo(null);

        //set the layout
        //create a global font to be used by the components
        Font globalFontBold = new Font("Lucida Grande", Font.BOLD, 13);
        Font globalFont = new Font("Lucida Grande", Font.PLAIN, 13);


        //create a new panel for the window's body
        JPanel mainBody = new JPanel();
        GridBagLayout mainBodyLayout = new GridBagLayout();
        GridBagConstraints mainBodyConstraints = new GridBagConstraints();
        mainBody.setLayout(mainBodyLayout);


        //create and initialize a label
        // that shows the information of the employee

        JTextArea employeeInformation = new JTextArea(
          "Name: " + employeeProfile.getName()
                  + "\nID: "
                  + employeeProfile.getId()
                  + "\nPosition: "
                  + employeeProfile.getPosition()
                  + "\nDepartment: "
                  + employeeProfile.getDepartment().departmentName(),
                4, 1
        );

        /*test driver start
        JTextArea employeeInformation = new JTextArea(
                "Name: " + "Luai Waleed" +
                        "\nID: " + "11" +
                        "\nPosition: " + "Computer Engineer" +
                        "\nDepartment: " + "Systems",
                4, 1
        ); *///test driver end
        //sets the font of the text area
        employeeInformation.setFont(globalFont);
        //make sure no one can edit the text area (read only)
        employeeInformation.setEditable(false);
        //make sure it has the same background as the main window
        employeeInformation.setBackground(getBackground());


        //create a new panel for buttons of the employee profile with grid layout
        // that takes 5 vertical items and one column
        GridLayout buttonsLayout = new GridLayout(5, 1);
        JPanel buttons = new JPanel(buttonsLayout);
        buttonsLayout.setVgap(20);


        //create button for marking attendance
        JButton markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setPreferredSize(new Dimension(150, 32));
        markAttendanceButton.setFont(globalFontBold);
        MarkAttendaceActionListener markAttendaceActionListener
                = new MarkAttendaceActionListener();
        markAttendanceButton.addActionListener(markAttendaceActionListener);

        //create button for viewing attendance history
        JButton viewAttendanceButton = new JButton("View Attendance History");
        viewAttendanceButton.setPreferredSize(new Dimension(150, 32));
        viewAttendanceButton.setFont(globalFontBold);
        ViewAttendaceActionListener viewAttendaceActionListener
                = new ViewAttendaceActionListener();
        viewAttendanceButton.addActionListener(viewAttendaceActionListener);

        //create button for gaining supervisor privileges
        JButton supervisorModeButton = new JButton("Log in as Supervisor");
        supervisorModeButton.setPreferredSize(new Dimension(150, 32));
        supervisorModeButton.setFont(globalFontBold);
        SupervisorModeActionListener supervisorModeActionListener
                = new SupervisorModeActionListener();
        supervisorModeButton.addActionListener(supervisorModeActionListener);

        //add gap before the buttons
        buttons.add(Box.createVerticalStrut(50));
        //add the buttons to their panel
        buttons.add(markAttendanceButton);
        buttons.add(viewAttendanceButton);
        buttons.add(supervisorModeButton);
        //add gap after the buttons
        buttons.add(Box.createVerticalStrut(50));


        //add panels to the main body
        mainBodyConstraints.anchor = GridBagConstraints.WEST;
        mainBodyConstraints.weightx = 0.05;
        mainBody.add(employeeInformation, mainBodyConstraints);
        mainBodyConstraints.anchor = GridBagConstraints.EAST;
        mainBody.add(buttons, mainBodyConstraints);
        //add components to the main window
        add(mainBody);
        //sets the window to be visible
        setVisible(true);

        //add action listener to the window to go back to the landing window
        // when this one gets closed
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is being closed.
             * sets the visibility of the previous page to be true
             * @param e
             */
            public void windowClosing(WindowEvent e) {
                landingWindow.setVisible(true);
            }
        });
    }

    private class MarkAttendaceActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        public void actionPerformed(ActionEvent e) {
            //mark the employee attendance
            //employeeProfile.markAttendance();
            //get the employee attendance state
            employeeProfile.markAttendance();
            String state; //changes according to the state
            if (employeeProfile.getAttendanceManager().getState())
                state = "Checked out";
            else
                state = "Checked in";

            Date checkTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String checkTimeString = sdf.format(checkTime);
            JOptionPane.showMessageDialog(EmployeeProfileWindow.this
                    , state + " successfully \nAt time: " + checkTimeString,
                    "Attendance Checked", JOptionPane.PLAIN_MESSAGE);

        }
    }

    private class ViewAttendaceActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        public void actionPerformed(ActionEvent e) {
            new ViewAttendanceWindow(EmployeeProfileWindow.this
                    , employeeProfile);
            EmployeeProfileWindow.this.setVisible(false);
        }
    }

    private class SupervisorModeActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        public void actionPerformed(ActionEvent e) {
            if (!employeeProfile.isSuperVisor()) {
                JOptionPane.showMessageDialog(EmployeeProfileWindow.this,
                        "You don't have enough permissions!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new SupervisorWindow(EmployeeProfileWindow.this, employeeProfile);
        }
    }

}
