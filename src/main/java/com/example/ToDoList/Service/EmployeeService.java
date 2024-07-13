package com.example.ToDoList.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ToDoList.Entity.Employee;
import com.example.ToDoList.Repositary.EmployeeRepositary;

@Service
public class EmployeeService implements EmployeeServices{
		
		@Autowired
		EmployeeRepositary ed;
		

		public List<Employee> getAllEmployee(){
			return ed.findAll();
		}
		
		public void save(Employee employee) {
			ed.save(employee);
		}
		
		public Employee getById(int id)
	    {
	        java.util.Optional<Employee> optional = ed.findById(id);
	        Employee employee = null;
	        if (optional.isPresent())
	            employee = optional.get();
	        else
	            throw new RuntimeException(
	                "Employee not found for id : " + id);
	        return employee;
	    }
		
		public void deleteViaId(int id)
	    {
	        ed.deleteById(id);
	    }
		
}
