package com.example.ttsjavakvt.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StaffData {
    private String staffCode;
    private String staffName;
    private String emailFPT;
    private String emailFE;
    private String departmentMajor;
}
