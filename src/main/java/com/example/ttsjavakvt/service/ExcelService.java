package com.example.ttsjavakvt.service;

import com.example.ttsjavakvt.dto.StaffData;
import com.example.ttsjavakvt.entity.Department;
import com.example.ttsjavakvt.entity.Facility;
import com.example.ttsjavakvt.entity.Major;
import com.example.ttsjavakvt.entity.Staff;

import java.util.List;

public interface ExcelService {
    void save(List<StaffData> staffData);

    Facility handleFacility(String facility);

    Department handleDepartment(String department);

    Major handleMajor(String major);

    String subString(String staffData, int index);

    Staff saveAndValid(Staff staff);

    void saveDepartmentAndMajor(Staff staff, Facility facility, Department department, Major major);
}
