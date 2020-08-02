package com.nova.hrs.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class Loguser {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_karyawan")
    private Karyawan karyawan;
    private LocalDateTime timelog;
    @Column(columnDefinition = "Text")
    private String keterangan;
}
