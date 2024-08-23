package com.example.ttsjavakvt.repository;

import com.example.ttsjavakvt.model.DepartmentFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentFacilityRepository extends JpaRepository<DepartmentFacility, String> {
}
