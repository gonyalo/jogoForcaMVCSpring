package com.websystique.springmvc.controller;
 
import java.util.List;
import java.util.Locale;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.TesteServiceInterface;
import com.websystique.springmvc.model.Teste;

import com.websystique.springmvc.service.CategoryServiceInterface; 
import com.websystique.springmvc.model.Category;
import com.websystique.springmvc.service.DifficultyServiceInterface;
import com.websystique.springmvc.model.Difficulty;
 
@Controller
@RequestMapping("/")
public class AppController {
 

    @Autowired
    EmployeeService service;

    @Autowired
    TesteServiceInterface serviceTeste;

    @Autowired
    CategoryServiceInterface serviceCategory;

    @Autowired
    DifficultyServiceInterface serviceDifficulty;

    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
/*    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
 
        List<Employee> employees = service.findAllEmployees();
        model.addAttribute("employees", employees);
        return "allemployees";
    }*/
 
    /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
         
        service.saveEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = service.findEmployeeBySsn(ssn);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model, @PathVariable String ssn) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
 
        service.updateEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getName()  + " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an employee by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        service.deleteEmployeeBySsn(ssn);
        return "redirect:/list";
    }
 












    /*
     * New methods for "Jogo da Forca"
     */
    

    @RequestMapping(value = { "/" , "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap model){

        return "index";
    }

    @RequestMapping(value = { "/showLetsPlay" }, method = RequestMethod.GET)
    public String showLetsPlay(ModelMap model){

        List<Teste> listaTestes = serviceTeste.findAllTestes();
        model.addAttribute("listaTestes", listaTestes);

        List<Category> listCategories = serviceCategory.findAllCategories();
        model.addAttribute("listCategories", listCategories);


        List<Difficulty> listDifficulties = serviceDifficulty.findAllDifficulties();
        model.addAttribute("listDifficulties", listDifficulties);

        //List<Employee> employees = service.findAllEmployees();
        //model.addAttribute("employees", employees);

        return "letsPlay";
    }

    @RequestMapping(value = {"/showEdit"}, method = RequestMethod.GET)
    public String showEdit(ModelMap model){
        return "edit";
    }


    @RequestMapping(value ={"/submitPair"}, method = RequestMethod.GET)
    public String submitPair(ModelMap model, @RequestParam("category") String category, @RequestParam("difficulty") String difficulty){


        model.addAttribute("categoryTeste", category);
        model.addAttribute("difficultyteste", difficulty);

        return ""; 
        //return "redirect:/showLetsPlay";
        //return "letsPlay";
    }
}