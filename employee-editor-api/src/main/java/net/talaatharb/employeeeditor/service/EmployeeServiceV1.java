/**
 * 
 */
package net.talaatharb.employeeeditor.service;

import java.util.List;
import java.util.UUID;

import net.talaatharb.employeeeditor.dto.EmployeeDtoV1;

/**
 * An interface for performing Employee related tasks in the back-end
 * 
 * @author mharb
 *
 */
public interface EmployeeServiceV1 {
	/**
	 * Method to create a Employee
	 * 
	 * @param employeeDtoV1 The Employee to create
	 * @return The created Employee
	 */
	public EmployeeDtoV1 createEmployee(final EmployeeDtoV1 employeeDtoV1);

	/**
	 * Method to delete a Employee
	 * 
	 * @param id The ID of the Employee to be deleted
	 */
	public void deleteEmployee(final UUID id);

	/**
	 * Method to get all Employees
	 * 
	 * @return List of all Employees
	 */
	public List<EmployeeDtoV1> readAllEmployees();

	/**
	 * Method to get a Employee given its ID
	 * 
	 * @param id ID of the Employee to get
	 * @return The Employee to get if it is available
	 */
	public EmployeeDtoV1 readEmployee(final UUID id);

	/**
	 * Method to update a Employee
	 * 
	 * @param id            The ID of the Employee to update
	 * @param employeeDtoV1 The Employee to update
	 * @return The updated Employee
	 */
	public EmployeeDtoV1 updateEmployee(final UUID id, final EmployeeDtoV1 employeeDtoV1);
}
