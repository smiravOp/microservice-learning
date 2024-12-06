package com.netguides.employee_service.service;

import com.netguides.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentServiceAPI {

    @GetMapping("/api/department/getDepartmentByCode/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);
}
