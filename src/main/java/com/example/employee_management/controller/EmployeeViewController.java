package com.example.employee_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;  // ← Khác với @RestController!
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
// Để sử dụng thymeleaf render ra template html
public class EmployeeViewController {

    private final EmployeeService employeeService;

    public EmployeeViewController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees/list";  
        // Tìm file: templates/employees/list.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto()); //Bind form
        return "employees/add";  
        //Tìm file: templates/employees/add.html
    }

    @PostMapping("/add")
    public String addEmployee(
            @Valid @ModelAttribute("employeeDto") EmployeeDto dto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "employees/add"; // có lỗi → quay lại form, không redirect
        }

        employeeService.addEmployee(dto);
        return "redirect:/employees/list"; // thành công → trả về danh sách
    }

    @GetMapping("/search")
    public String searchEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String departmentName,
            Model model) {

        model.addAttribute("employees", employeeService.searchEmployees(name, departmentName));
        model.addAttribute("name", name);
        model.addAttribute("departmentName", departmentName);
        return "employees/search"; // → templates/employees/search.html
    }
}


