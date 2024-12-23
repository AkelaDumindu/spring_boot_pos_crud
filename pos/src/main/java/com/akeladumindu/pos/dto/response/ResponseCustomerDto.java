package com.akeladumindu.pos.dto.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseCustomerDto {

    public long publicId;
    private String name;
    private String address;
    private double salary;
    private boolean activeState;
}
