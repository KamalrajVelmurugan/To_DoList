package com.example.ToDoList.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.Entity.Employee;

public interface EmployeeRepositary extends JpaRepository<Employee, Integer>{

}
