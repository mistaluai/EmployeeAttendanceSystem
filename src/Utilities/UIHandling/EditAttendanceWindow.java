package Utilities.UIHandling;

import Backend.Entities.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;

public class EditAttendanceWindow extends JFrame {

    private Supervisor supervisorProfile;
    private SupervisorWindow supervisorWindow;
    private int ID;

    public EditAttendanceWindow(SupervisorWindow supervisorWindow, Supervisor supervisorProfile, int ID) {
        //set the supervisor profile to access his data
        this.supervisorProfile = (Supervisor) supervisorProfile;
        //set the id of the target employee
        this.ID = ID;
        //set the profile window to access it if we wanted to go back
        this.supervisorWindow = supervisorWindow;

        //Sets title of the window
        setTitle("Update the attendance record");
        //sets the size of the window
        setSize(400, 300);
        setMinimumSize(new Dimension(400, 300));
        setMaximumSize(new Dimension(400, 300));
        //set the layout
        setLayout(new GridLayout(5,1));

        //create a global font to be used by the components
        Font globalFontBold = new Font("Lucida Grande", Font.BOLD, 18);
        Font globalFont = new Font("Lucida Grande", Font.PLAIN, 13);

        //create a panel for the header label
        JPanel header = new JPanel();

        //create the header label
        JLabel headerLabel = new JLabel("Attendance Editor");
        headerLabel.setFont(globalFontBold);
        //add the label to the panel
        header.add(headerLabel);

        //create panel for the date picking field
        JPanel datePickingPanel = new JPanel(new FlowLayout());

        //create a new label that indicates the date picking
        JLabel datePickerIndicator = new JLabel("Date: ");
        datePickerIndicator.setFont(globalFont);

        //create the date picking field
        //create a date model for the spinner field
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(new Date(), null, null, Calendar.MONTH);
        //initialize the date picker
        JSpinner datePicker = new JSpinner(spinnerDateModel);
        //sets its preferred size
        datePicker.setPreferredSize(new Dimension(128, 32));
        //create a date editor for formatting the date in the spinner field
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datePicker, "dd/MM/yy");
        //set the editor
        datePicker.setEditor(dateEditor);

        //add the date picker and its label to their parent panel
        datePickingPanel.add(datePickerIndicator);
        datePickingPanel.add(datePicker);

        //create a panel for the time in picking
        JPanel timeInPickerPanel = new JPanel(new FlowLayout());

        //create a new label that indicates the date picking
        JLabel timeInPickerIndicator = new JLabel("Time in: ");
        timeInPickerIndicator.setFont(globalFont);

        //create the picker of the time in
        //create a date model for the spinner field
        SpinnerDateModel spinnerTimeInModel = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        //initialize the date picker
        JSpinner timeInPicker = new JSpinner(spinnerTimeInModel);
        //sets its preferred size
        timeInPicker.setPreferredSize(new Dimension(128, 32));
        //create a date editor for formatting the date in the spinner field
        JSpinner.DateEditor timeInEditor = new JSpinner.DateEditor(timeInPicker, "HH:mm");
        //set the editor
        timeInPicker.setEditor(timeInEditor);

        //add the time in picker to its parent panel
        timeInPickerPanel.add(timeInPickerIndicator);
        timeInPickerPanel.add(timeInPicker);

        //create a panel for the time out picking
        JPanel timeOutPickerPanel = new JPanel(new FlowLayout());

        //create a new label that indicates the date picking
        JLabel timeOutPickerIndicator = new JLabel("Time out: ");
        timeInPickerIndicator.setFont(globalFont);

        //create the picker of the time in
        //create a date model for the spinner field
        SpinnerDateModel spinnerTimeOutModel = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        //initialize the date picker
        JSpinner timeOutPicker = new JSpinner(spinnerTimeOutModel);
        //sets its preferred size
        timeOutPicker.setPreferredSize(new Dimension(128, 32));
        //create a date editor for formatting the date in the spinner field
        JSpinner.DateEditor timeOutEditor = new JSpinner.DateEditor(timeOutPicker, "HH:mm");
        //set the editor
        timeOutPicker.setEditor(timeOutEditor);
        //add the time in picker to its parent panel
        timeOutPickerPanel.add(timeOutPickerIndicator);
        timeOutPickerPanel.add(timeOutPicker);

        //create panel for the set button
        JPanel setButtonPanel = new JPanel(new FlowLayout());

        //create new button for setting the date
        JButton setButton = new JButton("Set");
        //set the font of the button
        setButton.setFont(globalFont);

        //add its action listener
        SetButtonActionListener setButtonActionListener = new SetButtonActionListener();
        setButton.addActionListener(setButtonActionListener);

        //add the button to its panel
        setButtonPanel.add(setButton);

        //add content panels to the main layout
        add(header);
        add(datePickingPanel);
        add(timeInPickerPanel);
        add(timeOutPickerPanel);
        add(setButtonPanel);
        //show the window
        setVisible(true);

        //add action listener to the window to go back to the supervisor window when this one gets closed
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
    private class SetButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        public void actionPerformed(ActionEvent e) {

        }
    }
    public static void main(String[] args) {

    }
}
