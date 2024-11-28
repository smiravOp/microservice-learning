package com.netguides.department_service.controller;

import com.netguides.department_service.dto.DepartmentDto;
import com.netguides.department_service.service.DepartmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentServiceImpl departmentService;

    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/getDepartmentByCode/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code),HttpStatus.OK);
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments(),HttpStatus.OK);
    }

    @PutMapping("/updateDepartment/{code}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto,
                                                          @PathVariable String code){
        departmentDto.setDepartmentCode(code);
        return new ResponseEntity<>(departmentService.updateDepartment(departmentDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteDepartment/{code}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String code){
        departmentService.deleteDepartment(code);
        return new ResponseEntity<>("Department deleted successfully",HttpStatus.OK);
    }
}
