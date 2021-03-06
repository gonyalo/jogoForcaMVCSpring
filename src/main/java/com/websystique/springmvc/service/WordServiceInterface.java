package com.websystique.springmvc.service;
 
import java.util.List;
 
//import com.websystique.springmvc.model.Employee;

import com.websystique.springmvc.model.Word;

public interface WordServiceInterface {
 
    /*Employee findById(int id);
     
    void saveEmployee(Employee employee);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
 
    List<Employee> findAllEmployees(); 
     
    Employee findEmployeeBySsn(String ssn);
 
    boolean isEmployeeSsnUnique(Integer id, String ssn);*/

    List<Word> findAllWords();
    List<Word> findWordByDifficultyAndCategory(String difficulty, String category);
     
}