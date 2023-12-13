package Utilities.UIHandling;

import Backend.Entities.Employee;

import javax.swing.*;
import java.awt.*;

public class EmployeeProfile extends JFrame {
    Employee employeeProfile;
    LandingWindow landingWindow;
    public EmployeeProfile(LandingWindow landingWindow, Employee employeeProfile) {
        //set the employee profile to access his data
        this.employeeProfile = employeeProfile;
        //set the landing window to access it if we wanted to go back
        this.landingWindow = landingWindow;

        //Sets title of the window
        setTitle("Employee's Profile");
        //sets the size of the window
        setSize(400, 400);
        setMinimumSize(new Dimension(400, 400));
        setMaximumSize(new Dimension(400, 400));
        //create a global font to be used by the components
        Font globalFontBold = new Font("Lucida Grande", Font.BOLD, 13);
        Font globalFont = new Font("Lucida Grande", Font.PLAIN, 13);


        //create and initialize a title label with the employee's name
        //JLabel titleLable = new JLabel(employeeProfile.getName() + "'s Name", JLabel.CENTER );
        JLabel titleLable = new JLabel("Luai" + "'s Name", JLabel.CENTER); //test driver
        titleLable.setFont(globalFontBold);

        //create a new panel for the window's body
        JPanel mainBody = new JPanel(new GridLayout(1,2));

        //create new panel for the employee's information
        JPanel information = new JPanel();
        //create and initialize a label that shows the information of the employee

        /*
        JTextArea profileLabel = new JTextArea(
          "Name: " + employeeProfile.getName() +
          "\nID: " + employeeProfile.getId() +
          "\nPosition: " + employeeProfile.getPosition() +
                  "\nDepartment: " + employeeProfile.getDepartment().getDepartmentName(),
                4, 1
        );
        */
        //test driver start
        JTextArea profileLabel = new JTextArea(
                "Name: " + "Luai Waleed" +
                        "\nID: " + "11" +
                        "\nPosition: " + "Computer Engineer" +
                        "\nDepartment: " + "Computers & Systems Department",
                4, 1
        ); //test driver end
        //sets the font of the text area
        profileLabel.setFont(globalFont);
        //make sure no one can edit the text area (read only)
        profileLabel.setEditable(false);
        //make sure it has the same background as the main window
        profileLabel.setBackground(getBackground());
        //adds the text area to the panel
        information.add(profileLabel);

        //add panels to the main body
        mainBody.add(information);
        //add components to the main window
        add(titleLable);
        add(mainBody);
        //sets the windows to be visible
        setVisible(true);
    }
}
