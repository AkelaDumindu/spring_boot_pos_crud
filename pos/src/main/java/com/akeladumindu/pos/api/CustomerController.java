package com.akeladumindu.pos.api;


import com.akeladumindu.pos.db.Database;
import com.akeladumindu.pos.dto.request.RequestCustomerDto;
import com.akeladumindu.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(
            @RequestBody
            RequestCustomerDto customerDto
    ) {
        var savedData = Database.createCustomer(customerDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Seved", savedData.toString()),
                HttpStatus.CREATED
        );

    }

    @PutMapping
    public String updateCustomer() {
        return "Customer updated";
    }

    @DeleteMapping
    public String deleteCustomer() {
        return "Customer deleted";
    }

    @GetMapping
    public String findCustomer() {
        return "find customer";
    }

    @GetMapping("/list")
    public String findAllCustomers() {
        return "Customer find all";
    }
}
