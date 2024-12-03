package com.netguides.employee_service.service;

import com.netguides.employee_service.dto.APIResponseDto;
import com.netguides.employee_service.dto.DepartmentDto;
import com.netguides.employee_service.dto.EmployeeDto;
import com.netguides.employee_service.entity.Employee;
import com.netguides.employee_service.externalServices.DepartmentServiceAPI;
import com.netguides.employee_service.mapper.EmployeeMapper;
import com.netguides.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private DepartmentServiceAPI departmentService;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

         Employee employee = EmployeeMapper.mapper.mapToEmployee(employeeDto);

         return EmployeeMapper.mapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).get();

        DepartmentDto departmentDto = departmentService.getDepartmentByCode(employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(EmployeeMapper.mapper.mapToEmployeeDto(employee));
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

       List<Employee> employeeList = employeeRepository.findAll();

       return employeeList.stream()
               .map(EmployeeMapper.mapper::mapToEmployeeDto)
               .toList();
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {

       Employee employee = employeeRepository.findById(employeeDto.getId()).get();

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

       return EmployeeMapper.mapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.deleteById(employee.getId());
    }
}
