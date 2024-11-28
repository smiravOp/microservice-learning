package com.netguides.department_service.Mapper;

import com.netguides.department_service.dto.DepartmentDto;
import com.netguides.department_service.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper mapper = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);
}
