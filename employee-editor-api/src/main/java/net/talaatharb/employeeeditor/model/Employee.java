/**
 * 
 */
package net.talaatharb.employeeeditor.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Employee entity
 * 
 * @author mharb
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {

	/**
	 * Email of employee
	 */
	private String email;

	/**
	 * First name of employee
	 */
	private String firstName;

	/**
	 * ID of the Employee
	 */
	@Id
	private UUID id;

	/**
	 * Last name of employee
	 */
	private String lastName;
}
