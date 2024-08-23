package com.example.ttsjavakvt.service;

import com.example.ttsjavakvt.dto.DataRequest;
import com.example.ttsjavakvt.model.Department;
import com.example.ttsjavakvt.model.Facility;
import com.example.ttsjavakvt.model.Major;
import com.example.ttsjavakvt.model.StaffMajorFacility;

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
