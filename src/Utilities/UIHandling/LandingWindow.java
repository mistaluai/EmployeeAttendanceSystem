package Utilities.UIHandling;

import Backend.Entities.Employee;
import Utilities.UIHandling.AccessLayer.EmployeeLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingWindow extends JFrame  {
    /**
     * Text field to get the id input in it
     */
    private JTextField idField;

    /**
     * Constructor
     */
    public LandingWindow() {
        //Sets title of the window
        setTitle("Employee Attendance System");
        //sets the size of the window
        setSize(400, 100);
        setMinimumSize(new Dimension(400, 100));
        setMaximumSize(new Dimension(400, 100));

        //set its position to center the screen
        setLocationRelativeTo(null);

        //create a global font to be used by the components
        Font globalFont = new Font("Lucida Grande", Font.BOLD, 13);
        //create new panel to add components to it
        JPanel landingPanel = new JPanel();

        //create and initialize new label to indicate to the user to enter the ID
        JLabel enterIdLabel = new JLabel("Enter ID");
        enterIdLabel.setFont(globalFont);

        //create and initialize text field to receive the employee id
        this.idField = new JTextField();
        idField.setPreferredSize(new Dimension(128, 32));
        idField.setFont(globalFont);

        //create and initialize button to log in with its action listener
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(128, 32));
        loginButton.setFont(globalFont);
        LoginActionListener loginActionListener = new LoginActionListener();
        loginButton.addActionListener(loginActionListener);


        //adds a small gap before the components
        landingPanel.add(Box.createVerticalStrut(60));
        //adds the initialized components to the panel
        landingPanel.add(enterIdLabel);
        landingPanel.add(idField);
        landingPanel.add(loginButton);

        //adds the main landing panel
        add(landingPanel);
        //sets the windows to be visible
        setVisible(true);
    }
    private class LoginActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        public void actionPerformed(ActionEvent e) {
            String ID = idField.getText();
            int idValue = 0;
            //makes sure that the text field is not empty
            if (ID.length() == 0) {
                //show a message that clearly tells the problem
                JOptionPane.showMessageDialog(LandingWindow.this, "ID can't be empty!"
                        , "Error", JOptionPane.ERROR_MESSAGE);
                //exit the execution
                return;
            }
            //makes sure that the text field doesn't contain any input but numbers
            try {
                //try to parse the ID to integer
                idValue = Integer.parseInt(ID);
            } catch (NumberFormatException nfe) {
                //show a message that clearly tells the problem
                JOptionPane.showMessageDialog(LandingWindow.this
                        , "ID can only include numbers!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                //exit the execution
                return;
            }
            //load the employee's data using the loader provided by the back end
            //Employee employeeAccount = IEmployeeLoader.getEmployee(idValue);
            Employee employeeAccount = new EmployeeLoader().getEmployee(idValue);
            if (employeeAccount == null) {
                JOptionPane.showMessageDialog(LandingWindow.this
                        , "ID invalid!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            //create new profile window
            EmployeeProfileWindow employeeProfileWindow =
                    new EmployeeProfileWindow(LandingWindow.this, employeeAccount);

            //hides current landing window
            LandingWindow.this.setVisible(false);

        }
    }
}
