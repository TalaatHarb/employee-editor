/**
 * 
 */
package net.talaatharb.employeeeditor.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EmployeeDto entity
 * 
 * @author mharb
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDtoV1 {

	/**
	 * Email of employee
	 */
	private String email;

	/**
	 * First name of employee
	 */
	private String firstName;

	/**
	 * ID of the EmployeeDto
	 */
	private UUID id;

	/**
	 * Last name of employee
	 */
	private String lastName;
}
