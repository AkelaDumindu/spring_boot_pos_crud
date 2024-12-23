package com.akeladumindu.pos.dto.core;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {

    private long id;
    public long publicId;
    private String name;
    private String address;
    private double salary;
    private boolean activeState;




}
