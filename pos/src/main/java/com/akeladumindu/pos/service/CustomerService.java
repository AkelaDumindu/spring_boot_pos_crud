package com.akeladumindu.pos.service;

import com.akeladumindu.pos.dto.request.RequestCustomerDto;
import com.akeladumindu.pos.dto.response.ResponseCustomerDto;
import com.akeladumindu.pos.dto.response.pagenated.model.CustomerPaginatedDto;

public interface CustomerService {

    public ResponseCustomerDto createCustomer(RequestCustomerDto dto);
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto);
    public void deleteCustomer(RequestCustomerDto dto);
    public ResponseCustomerDto findCustomer(long id) throws ClassNotFoundException;
    public CustomerPaginatedDto searchAllCustomer(int page, int size, String searchText);
}
