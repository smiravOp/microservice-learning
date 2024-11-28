package com.netguides.department_service.service;

import com.netguides.department_service.Mapper.DepartmentMapper;
import com.netguides.department_service.dto.DepartmentDto;
import com.netguides.department_service.entity.Department;
import com.netguides.department_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        return DepartmentMapper.mapper.mapToDepartmentDto(departmentRepository.save(DepartmentMapper.mapper.mapToDepartment(departmentDto)));
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        return DepartmentMapper.mapper.mapToDepartmentDto(departmentRepository.findByDepartmentCode(departmentCode));
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department> list = departmentRepository.findAll();
        return list.stream()
                .map(DepartmentMapper.mapper::mapToDepartmentDto)
                .toList();
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {

        Department department= departmentRepository.findById(departmentDto.getId()).get();

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentCode(departmentDto.getDepartmentCode());

        return DepartmentMapper.mapper.mapToDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public void deleteDepartment(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        departmentRepository.deleteByDepartmentCode(department.getDepartmentCode());
    }
}
