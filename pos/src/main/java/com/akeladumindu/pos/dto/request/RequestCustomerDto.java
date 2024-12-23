package com.akeladumindu.pos.dto.request;



import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestCustomerDto {

        private String name;
        private String address;
        private double salary;  // Lombok generates getSalary() method automatically

}
