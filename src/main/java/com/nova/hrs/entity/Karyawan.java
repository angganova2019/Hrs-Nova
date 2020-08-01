package com.nova.hrs.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Karyawan {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String firstName;
    private String lastName;
    private String alamat;
    private LocalDateTime tglLahir;
    private String tempatLahir;
    private String alamatKtp;
    private String statusMenikah;
    private String namaAyah;
    private String namaIbu;
    private String pekerjaanOrtu;

}
