package com.example.ttsjavakvt.repository;

import com.example.ttsjavakvt.entity.MajorFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorFacilityRepository extends JpaRepository<MajorFacility, String> {
}
