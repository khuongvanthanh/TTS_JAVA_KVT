package com.example.ttsjavakvt.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "major_facility")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MajorFacility extends AbstractEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_department_facility")
    private DepartmentFacility idDepartmentFacility;//Required

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_major")
    private Major idMajor;//Required

}