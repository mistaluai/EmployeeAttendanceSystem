package Backend.Entities;

/**
 * The Department class represents a department within the company.
 */
public class Department {
    // Private fields
    private final String departmentName; // The name of the department
    private Employee supervisor; // The supervisor of the department

    /**
     * Constructs a Department object with a department name and supervisor.
     *
     * @param departmentName The name of the department.
     * @param supervisor     The supervisor of the department.
     */
    public Department(String departmentName, Employee supervisor) {
        this.departmentName = departmentName;
        this.supervisor = supervisor;
    }

    /**
     * Retrieves the name of the department.
     *
     * @return The name of the department.
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Retrieves the supervisor of the department.
     *
     * @return The supervisor of the department.
     */
    public Employee getSupervisor() {
        return supervisor;
    }
}