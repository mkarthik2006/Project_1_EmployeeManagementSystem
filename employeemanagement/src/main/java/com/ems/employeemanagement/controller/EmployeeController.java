package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.entity.Employee;
import com.ems.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("totalPages", 1);
        return "employees";
    }

    @PostMapping
    public String createEmployee(@Valid @ModelAttribute Employee employee) {
        service.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee"; // Ensure this template exists
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid @ModelAttribute Employee employee) {
        service.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/search")
    public String searchEmployees(@RequestParam(required = false) String keyword, Model model) {
        List<Employee> employees = (keyword == null || keyword.trim().isEmpty()) ?
                service.getAllEmployees() : service.searchEmployeesByName(keyword);
        model.addAttribute("employees", employees);
        model.addAttribute("totalPages", 1); // No pagination for search results
        return "employees"; // Ensure this matches your Thymeleaf template
    }
}