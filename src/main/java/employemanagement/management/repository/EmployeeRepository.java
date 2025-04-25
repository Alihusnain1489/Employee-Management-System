package employemanagement.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employemanagement.management.entity.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
    
}
