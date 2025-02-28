package com.akeladumindu.pos.api;



import com.akeladumindu.pos.dto.request.RequestCustomerDto;
import com.akeladumindu.pos.service.CustomerService;
import com.akeladumindu.pos.service.impl.CustomerServiceImpl;
import com.akeladumindu.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(
            @RequestBody
            RequestCustomerDto customerDto
    ) {
        var savedData = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Seved", savedData),
                HttpStatus.CREATED
        );

    }

    @PutMapping(params = "id")
    public  ResponseEntity<StandardResponse> updateCustomer(
            @RequestParam int id,
            @RequestBody RequestCustomerDto customerDto
    ) throws ClassNotFoundException {
        var savedData = customerService.updateCustomer(customerDto, id);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Updated", savedData),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<StandardResponse> deleteCustomer(
            @RequestParam int id

    ) throws ClassNotFoundException {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Customer Deleted", null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable long id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer Data", customerService.findCustomer(id)),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/list", params = {"page","size","searchText"})
    public ResponseEntity<StandardResponse> findAllCustomers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String searchText
    ){
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer List", customerService.searchAllCustomer(page, size, searchText)),
                HttpStatus.OK
        );
    }
}