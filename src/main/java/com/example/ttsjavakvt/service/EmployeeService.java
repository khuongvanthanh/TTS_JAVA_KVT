package com.example.ttsjavakvt.service;

import com.example.ttsjavakvt.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<?> getAllEmp();

    void updateStatus(String id);

    Optional<Staff> getStaffById(String id);

    Staff saveEmp(Staff staff);

    boolean existsByAccountFe(String accountFe);

    boolean existsByAccountFpt(String accountFpt);

    boolean existsByStaffCode(String staffCode);

    List<Staff> searchByKeyword(String keyword);

    List<Staff> getStaffByStatus(int status);
}
