Educational Project at Fayoum University
Employee Attendance System:
 
Entities:
   Employee: Name, ID, Department, Position
   AttendanceRecord: Date, Time In, Time Out
   Department: Department Name, Supervisor
 
Operations:
   Mark Attendance: Record time in and time out for an employee
   Edit Attendance: Update time in or time out for a given day
   View Attendance History: Display attendance records for an employee
 
Design Patterns:
   State for representing different attendance states
   Command for managing attendance operations
 
User Interaction:
   Users interact with the application through an executable JAR file.
   The JAR file opens a window displaying options (mark/edit/view) using
    JOptionPane.showInputDialog for user input
