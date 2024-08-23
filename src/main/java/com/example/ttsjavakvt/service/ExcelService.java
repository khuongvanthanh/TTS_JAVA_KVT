package com.example.ttsjavakvt.service;

import com.example.ttsjavakvt.dto.StaffData;
import com.example.ttsjavakvt.model.Department;
import com.example.ttsjavakvt.model.Facility;
import com.example.ttsjavakvt.model.Major;
import com.example.ttsjavakvt.model.Staff;

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
