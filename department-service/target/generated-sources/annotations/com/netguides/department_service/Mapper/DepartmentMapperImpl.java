package com.netguides.department_service.Mapper;

import com.netguides.department_service.dto.DepartmentDto;
import com.netguides.department_service.entity.Department;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T20:04:53+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto mapToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getId() );
        departmentDto.setDepartmentName( department.getDepartmentName() );
        departmentDto.setDepartmentDescription( department.getDepartmentDescription() );
        departmentDto.setDepartmentCode( department.getDepartmentCode() );

        return departmentDto;
    }

    @Override
    public Department mapToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDto.getId() );
        department.setDepartmentName( departmentDto.getDepartmentName() );
        department.setDepartmentDescription( departmentDto.getDepartmentDescription() );
        department.setDepartmentCode( departmentDto.getDepartmentCode() );

        return department;
    }
}
