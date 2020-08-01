package com.nova.hrs.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Karyawan {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_kantor")
    private Kantor kantor;

    @NotNull
    private String nip;
    @NotNull
    private String ktp;
    private String firstName;
    private String lastName;
    private String jenisKelamin;
    private String tempatLahir;
    private LocalDate tglLahir;
    private String agama;
    private String alamatTinggal;
    private String alamatKtp;
    @Column(columnDefinition = "Numeric(1)")
    private int statusTempatTinggal;
    @Column(columnDefinition = "Numeric(2)")
    private int jumlahSaudara;
    @Column(columnDefinition = "Numeric(1)")
    private int statusMenikah;
    private String namaPasangan;
    @Column(columnDefinition = "Numeric(2)")
    private int jumlahAnak;
    private String ayah;
    private String ibu;
    @Column(columnDefinition = "TEXT")
    private String foto;
    @Column(length = 45)
    private String hp;
    @Column(columnDefinition = "TEXT")
    private String infoLain;
    private LocalDate tglMulaiKerja;
    private LocalDate tglKeluar;
    @Column(columnDefinition = "Numeric(4)")
    private int sisaCuti;
    @Column(length = 100)
    private String npwp;
    private LocalDateTime timeUpdate;

}
