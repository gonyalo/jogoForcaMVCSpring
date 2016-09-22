package com.websystique.springmvc.dao;
 
import java.util.List;
 
//import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.Teste;

 
public interface TesteDaoInterface {
 
	List<Teste> findAllTestes();

 /*
    Employee findById(int id);
 
    void saveEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
     
    List<Employee> findAllEmployees();
 
    Employee findEmployeeBySsn(String ssn);
 */
}