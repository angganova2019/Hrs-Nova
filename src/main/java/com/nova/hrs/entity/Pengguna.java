package com.nova.hrs.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Pengguna {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_karyawan")
    private Karyawan karyawan;

    @NotEmpty
    @Size(min = 2, max = 255)
    @Email
    private String email;
    private String password;
    private boolean active = false;
    private String roles;
    private LocalDateTime lastLogin;
}
