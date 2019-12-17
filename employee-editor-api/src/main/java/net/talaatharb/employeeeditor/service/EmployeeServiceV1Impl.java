/**
 * 
 */
package net.talaatharb.employeeeditor.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import net.talaatharb.employeeeditor.dto.EmployeeDtoV1;
import net.talaatharb.employeeeditor.mapper.EntityMapper;
import net.talaatharb.employeeeditor.model.Employee;
import net.talaatharb.employeeeditor.repository.EmployeeRepository;

/**
 * Implementation of the EmployeeServiceV1 interface
 * 
 * @author mharb
 *
 */
@Service
public class EmployeeServiceV1Impl implements EmployeeServiceV1 {

	@Autowired
	private EntityMapper<Employee, EmployeeDtoV1> employeeMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDtoV1 createEmployee(final EmployeeDtoV1 employeeDto) {
		if (employeeDto != null) {
			final Employee employee = employeeRepository.save(employeeMapper.toEntity(employeeDto));
			return employeeMapper.toDto(employee);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Employee found");
		}
	}

	@Override
	public void deleteEmployee(final UUID id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDtoV1> readAllEmployees() {
		return employeeMapper.toDto(employeeRepository.findAll());
	}

	@Override
	public EmployeeDtoV1 readEmployee(final UUID id) {
		final Optional<Employee> possibleResource = employeeRepository.findById(id);
		if (possibleResource.isPresent()) {
			return employeeMapper.toDto(possibleResource.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find Employee");
		}
	}

	@Override
	public EmployeeDtoV1 updateEmployee(final UUID id, final EmployeeDtoV1 employeeDto) {
		if (id != null && employeeDto != null) {
			employeeDto.setId(id);
			final Employee employee = employeeRepository.save(employeeMapper.toEntity(employeeDto));
			return employeeMapper.toDto(employee);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have to have a valid Employee");
		}
	}
}
