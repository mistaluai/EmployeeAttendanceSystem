package Backend.Entities;

/**
 * The Department class represents a department within the company.
 *
 * @param departmentName Private fields The name of the department
 * @param supervisor     The supervisor of the department
 */
public record Department(String departmentName, String supervisor) {}