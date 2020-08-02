package com.nova.hrs.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class Devisi {
    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    @JoinColumn(name = "id_kantor")
    private Kantor kantor;
    @Size(min = 2, max = 45)
    private String nama;
    @Column(columnDefinition = "Numeric(4)")
    private int urutan;
}
