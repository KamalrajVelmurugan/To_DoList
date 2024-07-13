package com.example.ToDoList.Service;

import java.util.List;

import com.example.ToDoList.Entity.Employee;

public interface EmployeeServices {
	
	   List<Employee> getAllEmployee();
	    void save(Employee employee);
	    Employee getById(int id);
	    void deleteViaId(int id);
}
