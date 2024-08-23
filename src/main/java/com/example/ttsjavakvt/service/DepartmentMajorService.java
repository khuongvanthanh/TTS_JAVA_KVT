package com.example.ttsjavakvt.service;

import com.example.ttsjavakvt.dto.DataRequest;
import com.example.ttsjavakvt.entity.Department;
import com.example.ttsjavakvt.entity.Facility;
import com.example.ttsjavakvt.entity.Major;
import com.example.ttsjavakvt.entity.StaffMajorFacility;

import java.util.List;

public interface DepartmentMajorService {
    List<StaffMajorFacility> getInfoByStaff(String idStaff);

    List<Department> getDepartment();

    List<Facility> getFacilityByStaff(String idStaff);

    List<Facility> getFacilityByStaff();

    List<Major> getMajors();

    void storeData(DataRequest request);

    void deleteData(String idStaffMajorFacility);
}
