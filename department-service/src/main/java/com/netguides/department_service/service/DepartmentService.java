package com.netguides.department_service.service;

import com.netguides.department_service.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentCode);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(DepartmentDto departmentDto);

    void deleteDepartment(String departmentCode);
}
