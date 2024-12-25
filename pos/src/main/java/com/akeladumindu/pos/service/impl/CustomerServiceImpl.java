package com.akeladumindu.pos.service.impl;

import com.akeladumindu.pos.dto.core.CustomerDto;
import com.akeladumindu.pos.dto.request.RequestCustomerDto;
import com.akeladumindu.pos.dto.response.ResponseCustomerDto;
import com.akeladumindu.pos.dto.response.pagenated.model.CustomerPaginatedDto;
import com.akeladumindu.pos.entitiy.Customer;
import com.akeladumindu.pos.repo.CustomerRepo;
import com.akeladumindu.pos.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public ResponseCustomerDto createCustomer(RequestCustomerDto dto) {
        CustomerDto customerDto = new CustomerDto(
                0,
                new Random().nextInt(100001),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                true,
                null,
                null,
                null,
                null

        );

        Customer customer = new Customer(
                0,
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                true,
                null


        );

            customerRepo.save(customer);

        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState()
        );
    }

    @Override
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto) {
        return null;
    }

    @Override
    public void deleteCustomer(RequestCustomerDto dto) {

    }

    @Override
    public ResponseCustomerDto findCustomer(long id) {
        return null;
    }

    @Override
    public CustomerPaginatedDto searchAllCustomer(int page, int size, String searchText) {
        return null;
    }
}
