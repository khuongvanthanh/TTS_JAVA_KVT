package com.example.ttsjavakvt.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "department_facility")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentFacility extends AbstractEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_department")
    private Department idDepartment;//Required

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_staff")
    private Staff idStaff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_facility")
    private Facility idFacility;//Required
}