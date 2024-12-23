package com.akeladumindu.pos.api;


import com.akeladumindu.pos.db.Database;
import com.akeladumindu.pos.dto.request.RequestCustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping
    public String createCustomer(
            @RequestBody
            RequestCustomerDto customerDto
    ) {
        return Database.createCustomer(customerDto).toString();
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
