package employemanagement.management.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "emp_id")
    private int id;
    @Column (name = "emp_name")
    private String empName;
    @Column (name = "emp_city")
    private String city;
    @Column(name = "emp_Salary")
    private double empSalary;
    @Column(name = "emp_bonus")
    private double bonus;
   
 
 
    
}
