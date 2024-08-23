package com.example.ttsjavakvt.model;

import com.example.ttsjavakvt.Exception.EmailFe;
import com.example.ttsjavakvt.Exception.EmailFpt;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Entity
@Table(name = "staff")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff extends AbstractEntity {
    @EmailFe
    @NotBlank(message = "Vui lòng không bỏ trống")
    @Column(name = "account_fe")
    private String accountFe;

    @EmailFpt
    @NotBlank(message = "Vui lòng không bỏ trống")
    @Column(name = "account_fpt")
    private String accountFpt;

    @NotBlank(message = "Vui lòng không bỏ trống")
    @Length(max = 100, message = "Tên quá dài")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Vui lòng không bỏ trống")
    @Length(max = 14, message = "Mã nhỏ hơn 15 ký tự")
    @Column(name = "staff_code")
    private String staffCode;

}