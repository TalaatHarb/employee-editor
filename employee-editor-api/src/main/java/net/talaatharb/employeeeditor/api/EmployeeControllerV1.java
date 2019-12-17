/**
 * 
 */
package net.talaatharb.employeeeditor.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.talaatharb.employeeeditor.dto.EmployeeDtoV1;
import net.talaatharb.employeeeditor.service.EmployeeServiceV1;

/**
 * Employee controller
 * 
 * @author mharb
 *
 */
@RestController
@RequestMapping(path = "/api/employees")
@Api(tags = { "Employee" })
public class EmployeeControllerV1 {
	@Autowired
	private EmployeeServiceV1 employeeService;

	/**
	 * Method to create a Employee
	 * 
	 * @param employeeDtoV1 The Employee to create
	 * @return The created Employee
	 */
	@PostMapping(path = "")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create a Employee")
	public EmployeeDtoV1 createEmployee(@RequestBody final EmployeeDtoV1 employeeDtoV1) {
		return employeeService.createEmployee(employeeDtoV1);
	}

	/**
	 * Method to delete a Employee
	 * 
	 * @param id The ID of the Employee to be deleted
	 */
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete a Employee")
	public void deleteEmployee(@PathVariable final UUID id) {
		employeeService.deleteEmployee(id);
	}

	/**
	 * Method to get all Employees
	 * 
	 * @return List of all Employees
	 */
	@GetMapping(path = "")
	@ApiOperation(value = "Get all Employees")
	@ResponseStatus(HttpStatus.OK)
	public List<EmployeeDtoV1> getAllEmployees() {
		return employeeService.readAllEmployees();
	}

	/**
	 * Method to get a Employee given its ID
	 * 
	 * @param id ID of the Employee to get
	 * @return The Employee to get if it is available
	 */
	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Get a Employee")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeDtoV1 getEmployee(@PathVariable final UUID id) {
		return employeeService.readEmployee(id);
	}

	/**
	 * Method to update a Employee
	 * 
	 * @param id            The ID of the Employee to update
	 * @param employeeDtoV1 The Employee to update
	 * @return The updated Employee
	 */
	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Upadte a Employee")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeDtoV1 updateEmployee(@PathVariable final UUID id, @RequestBody final EmployeeDtoV1 employeeDtoV1) {
		return employeeService.updateEmployee(id, employeeDtoV1);
	}

	/**
	 * This method exist to allow the options pre-flight request for CORs to pass
	 * @param id
	 */
	@PutMapping(path = "/{id}", headers = "Access-Control-Request-Method=PUT")
	@ResponseStatus(HttpStatus.OK)
	public void optionsPut(@PathVariable final UUID id) {
		// Nothing
	}
	
	/**
	 * This method exist to allow the options pre-flight request for CORs to pass
	 * @param id
	 */
	@PostMapping(path = "", headers = "Access-Control-Request-Method=POST")
	@ResponseStatus(HttpStatus.OK)
	public void optionsPost() {
		// Nothing
	}
	
	/**
	 * This method exist to allow the options pre-flight request for CORs to pass
	 * @param id
	 */
	@DeleteMapping(path = "/{id}", headers = "Access-Control-Request-Method=DELETE")
	@ResponseStatus(HttpStatus.OK)
	public void optionsDelete(@PathVariable final UUID id) {
		// Nothing
	}
}