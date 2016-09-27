package com.websystique.springmvc.dao;
 
import java.util.List;
 
//import com.websystique.springmvc.model.Employee;
//import com.websystique.springmvc.model.Difficulty;
import com.websystique.springmvc.model.Word;
 
public interface WordDaoInterface {
 
	List<Word> findAllWords();


	List<Word> findWordByDifficultyAndCategory(String difficulty, String category);
 /*
    Employee findById(int id);
 
    void saveEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
     
    List<Employee> findAllEmployees();
 
    Employee findEmployeeBySsn(String ssn);
 */
}