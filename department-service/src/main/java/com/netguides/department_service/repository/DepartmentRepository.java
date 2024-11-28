package com.netguides.department_service.repository;

import com.netguides.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentCode(String departmentCode);

    void deleteByDepartmentCode(String departmentCode);
}
