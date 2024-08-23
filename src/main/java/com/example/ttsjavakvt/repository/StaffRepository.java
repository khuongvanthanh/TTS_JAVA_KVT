package com.example.ttsjavakvt.repository;

import com.example.ttsjavakvt.entity.Staff;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    @Modifying
    @Transactional
    @Query("UPDATE Staff SET status = :status WHERE id = :id")

    void updateStatus(String id, int status);

    boolean existsByAccountFe(String accountFe);

    boolean existsByAccountFpt(String accountFpt);

    boolean existsByStaffCode(String staffCode);

    @Query("FROM Staff WHERE name like %:keyword% OR accountFpt like %:keyword% OR accountFe like %:keyword% OR staffCode like %:keyword")
    List<Staff> searchByKeyword(@Param("keyword") String keyword);

    @Query("FROM Staff WHERE status = :status")
    List<Staff> findByStatus(@Param("status") int status);
}
