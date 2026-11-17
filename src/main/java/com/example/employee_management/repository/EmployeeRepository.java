package com.example.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_management.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//  Tìm kiếm theo tên
  List<Employee> findByNameContainingIgnoreCase(String name);

//  Tìm kiếm theo phòng ban
  List<Employee>findByDepartment_NameContainingIgnoreCase(String departmentName);

//  Tìm kiếm theo tên và phòng ban
  List<Employee>findByNameContainingIgnoreCaseAndDepartment_NameContainingIgnoreCase(String name, String departmentName);
}
