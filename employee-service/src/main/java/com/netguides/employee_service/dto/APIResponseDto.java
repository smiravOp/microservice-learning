package com.netguides.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class APIResponseDto {
    EmployeeDto employeeDto;
    DepartmentDto departmentDto;
}
