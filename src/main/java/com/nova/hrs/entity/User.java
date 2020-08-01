package com.nova.hrs.entity;


import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class User {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "id_karyawan")
//    private Karyawan karyawan;
    private String email;
    private String password;
    private boolean active = false;
    private String roles;
    private LocalDateTime lastLogin;



}
