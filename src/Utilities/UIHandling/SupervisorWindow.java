package Utilities.UIHandling;

import Backend.Entities.Employee;
import Backend.Entities.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SupervisorWindow extends JFrame {
    private Supervisor supervisorProfile;
    private EmployeeProfileWindow employeeProfileWindow;
    private JTextField idField;

    public SupervisorWindow(EmployeeProfileWindow employeeProfileWindow, Employee supervisorProfile) {
        //set the supervisor profile to access his data
        //this.supervisorProfile = (Supervisor) supervisorProfile;
        //set the profile window to access it if we wanted to go back
        //this.employeeProfileWindow = employeeProfileWindow;

        //Sets title of the window
        setTitle("Supervisor");
        //sets the size of the window
        setSize(400, 300);
        setMinimumSize(new Dimension(400, 300));
        setMaximumSize(new Dimension(400, 300));
        //set the layout
        setLayout(new GridLayout(2,1));
        //create a global font to be used by the components
        Font globalFontBold = new Font("Lucida Grande", Font.BOLD, 13);
        Font globalFont = new Font("Lucida Grande", Font.PLAIN, 13);

        //create a panel for the input field and its identifier
        JPanel inputPanel = new JPanel(new FlowLayout());

        //create a label with text "ID"
        JLabel idLabel = new JLabel("ID", JLabel.LEFT);
        idLabel.setFont(globalFontBold);

        //create a text field to recieve the ID in it
        this.idField = new JTextField();
        idField.setPreferredSize(new Dimension(128, 32));
        idField.setFont(globalFont);

        //add the components to the input panel
        inputPanel.add(idLabel);
        inputPanel.add(idField);

        //create new panel for the buttons
        JPanel buttons = new JPanel(new GridLayout(5,1));

        //create button for viewing attendance history of the employee
        JButton viewAttendanceHistoryButton = new JButton("View attendance History");
        viewAttendanceHistoryButton.setFont(globalFontBold);

        //create button for editing attendance history of the employee
        JButton editAttendanceButton = new JButton("Edit attendance");
        editAttendanceButton.setFont(globalFontBold);

        //add buttons to their parent panel
        buttons.add(viewAttendanceHistoryButton);
        buttons.add(editAttendanceButton);



        //add content panels to the frame
        add(inputPanel);
        add(buttons);
        //sets the window to be visible
        setVisible(true);

        //add action listener to the window to go back to the landing window when this one gets closed
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is being closed.
             * sets the visibility of the previous page to be true
             * @param e
             */
            public void windowClosing(WindowEvent e) {
                employeeProfileWindow.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new SupervisorWindow(null, null);
    }
}
