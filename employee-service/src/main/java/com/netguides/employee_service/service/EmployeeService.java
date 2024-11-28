package com.netguides.employee_service.service;

import com.netguides.employee_service.dto.APIResponseDto;
import com.netguides.employee_service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long id);

}
