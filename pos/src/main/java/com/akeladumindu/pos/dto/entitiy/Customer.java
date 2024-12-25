package com.akeladumindu.pos.dto.entitiy;

import com.akeladumindu.pos.dto.entitiy.process.FileResource;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long publicId;

    private String name;

    private String address;

    private double salary;

    @Column(columnDefinition = "TINYINT")
    private boolean activeState;

    @Embedded
    private FileResource fileResource;


}
