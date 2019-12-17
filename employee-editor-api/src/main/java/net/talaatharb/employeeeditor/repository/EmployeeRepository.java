/**
 * 
 */
package net.talaatharb.employeeeditor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.talaatharb.employeeeditor.model.Employee;

/**
 * Employee repository interface
 * 
 * @author mharb
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}