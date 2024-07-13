package com.example.ToDoList.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ToDoList.Entity.Employee;
import com.example.ToDoList.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	

	
	 @GetMapping("/")
	    public String viewHomePage(Model model) {
	        model.addAttribute("allemplist", es.getAllEmployee());
	        return "index";
	    }
	
    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }
    
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        es.save(employee);
        return "redirect:/";
    }
    @GetMapping("get/{a}")
    public Employee getById(@PathVariable int a) {
    	return es.getById(a);
    }
 
    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Employee employee = es.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }
 
    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) {
        es.deleteViaId(id);
        return "redirect:/";
 
    }
}
