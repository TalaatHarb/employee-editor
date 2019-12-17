/**
 * 
 */
package net.talaatharb.employeeeditor.mapper;

import org.springframework.stereotype.Component;

import net.talaatharb.employeeeditor.dto.EmployeeDtoV1;
import net.talaatharb.employeeeditor.model.Employee;

/**
 * An implementation of a mapper for Employees
 * 
 * @author mharb
 *
 */
@Component
public class EmployeeMapperV1 implements EntityMapper<Employee, EmployeeDtoV1> {

	@Override
	public EmployeeDtoV1 toDto(final Employee entity) {
		final EmployeeDtoV1 dto = new EmployeeDtoV1();

		dto.setId(entity.getId());
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());

		return dto;
	}

	@Override
	public Employee toEntity(final EmployeeDtoV1 dto) {
		final Employee entity = new Employee();

		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());

		return entity;
	}

}
