package employemanagement.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employemanagement.management.entity.Employee;
import employemanagement.management.exception.EmployeeNottFoundException;
import employemanagement.management.repository.EmployeeRepository;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping ("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
        
        
    }

    @PostMapping ("/employees")
    public Employee creatEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new EmployeeNottFoundException ("Employee with Employee Id"+empId+"does not exist"));
        return ResponseEntity.ok(employee); 
    }

    @PutMapping("/employees/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody Employee EmployeeDetails) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new EmployeeNottFoundException ("Employee with Employee Id"+empId+"does not exist"));
        employee.setEmpName(EmployeeDetails.getEmpName());
        employee.setDesignation(EmployeeDetails.getDesignation());
        employee.setEmpSalary(EmployeeDetails.getEmpSalary());
        employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new EmployeeNottFoundException ("Employee with Employee Id"+empId+"does not exist"));
        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<String,Boolean>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
