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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto, long id) throws ClassNotFoundException {
        Optional<Customer> selectedCustomer = customerRepo.findByPublicId(id);
        if(selectedCustomer.isEmpty()) throw new ClassNotFoundException();
                 selectedCustomer.get().setName(dto.getName());
                selectedCustomer.get().setAddress(dto.getAddress());
                selectedCustomer.get().setSalary(dto.getSalary());

                customerRepo.save(selectedCustomer.get());
        return new ResponseCustomerDto(
                selectedCustomer.get().getPublicId(),
                selectedCustomer.get().getName(),
                selectedCustomer.get().getAddress(),
                selectedCustomer.get().getSalary(),
                selectedCustomer.get().isActiveState()
        );


    }

    @Override
    public void deleteCustomer(long id) {
            customerRepo.deleteByPublicId(id);
    }

    @Override
    public ResponseCustomerDto findCustomer(long id) throws ClassNotFoundException {
        Optional<Customer> selectedCustomer = customerRepo.findByPublicId(id);

        if (selectedCustomer.isPresent()) {
            return new ResponseCustomerDto(
                    selectedCustomer.get().getPublicId(),
                    selectedCustomer.get().getName(),
                    selectedCustomer.get().getAddress(),
                    selectedCustomer.get().getSalary(),
                    selectedCustomer.get().isActiveState()
            );
        }

        throw new ClassNotFoundException();
    }

    @Override
    public CustomerPaginatedDto searchAllCustomer(int page, int size, String searchText) {
//        List<Customer> customers = customerRepo.findAll();
        Page<Customer> customers = customerRepo.searchAllByAddressOrName(searchText, PageRequest.of(page, size));
        List<ResponseCustomerDto> list = new ArrayList<>();
        long recordCount = customerRepo.countDataWithSearchText(searchText);

        for (Customer d : customers) {
            list.add(new ResponseCustomerDto(
                    d.getPublicId(),
                    d.getName(),
                    d.getAddress(),
                    d.getSalary(),
                    d.isActiveState()
            ));
        }

        return new CustomerPaginatedDto(recordCount, list);

    }


}
