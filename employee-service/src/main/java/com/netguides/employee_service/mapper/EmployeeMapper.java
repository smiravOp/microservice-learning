package com.netguides.employee_service.mapper;

import com.netguides.employee_service.dto.EmployeeDto;
import com.netguides.employee_service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);

}
