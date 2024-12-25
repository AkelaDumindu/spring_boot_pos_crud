package com.akeladumindu.pos.entitiy;

import com.akeladumindu.pos.entitiy.process.FileResource;
import jakarta.persistence.*;
import lombok.*;


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

    @Column(unique = true, nullable = false)
    public long publicId;

    private String name;

    private String address;

    private double salary;

    @Column(columnDefinition = "TINYINT")
    private boolean activeState;

    @Embedded
    private FileResource fileResource;


}
