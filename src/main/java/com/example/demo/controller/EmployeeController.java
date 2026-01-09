package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

        @Autowired
        private EmployeeRepository employeeRepository;

        //get
        @GetMapping("employees")
        public List<Employee> getAllEmployees() {
                return employeeRepository.findAll();
        }
        @GetMapping("employees/search")
        public List<Employee> searchEmployeesByName(@RequestParam String name) {
                return employeeRepository.findByNameContaining(name);
        }

        @GetMapping("employees/active")
        public List<Employee> getActiveEmployees() {
                return employeeRepository.findByActiveTrue();
        }

        @GetMapping("path")
        public String getMethodName(@RequestParam String param) {
            return new String();
        }
        
}
