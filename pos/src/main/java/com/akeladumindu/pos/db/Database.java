//package com.akeladumindu.pos.db;
//
//import com.akeladumindu.pos.dto.core.CustomerDto;
//import com.akeladumindu.pos.dto.request.RequestCustomerDto;
//import com.akeladumindu.pos.dto.response.ResponseCustomerDto;
//import com.akeladumindu.pos.dto.response.pagenated.model.CustomerPaginatedDto;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//public class Database {
//
//    public static ArrayList<CustomerDto> customerTable = new ArrayList<>();
//
////    without database
////    public static ResponseCustomerDto createCustomer(RequestCustomerDto dto) {
////        CustomerDto customerDto = new CustomerDto(
////                new Random().nextInt(100001),
////                new Random().nextInt(100001),
////                dto.getName(),
////                dto.getAddress(),
////                dto.getSalary(),
////                true,
////                null,
////                null,
////                null,
////                null
////
////        );
////
////        customerTable.add(customerDto);
////
////        return new ResponseCustomerDto(
////                customerDto.getPublicId(),
////                dto.getName(),
////                dto.getAddress(),
////                dto.getSalary(),
////                customerDto.isActiveState()
////        );
////    }
//
//    public static ResponseCustomerDto findCustomer(int id) throws ClassNotFoundException {
//
//        Optional<CustomerDto> selectedCustomer = customerTable.stream()
//                .filter(e -> e.getPublicId() == id)
//                .findFirst();
//
//        if (selectedCustomer.isPresent()) {
//            return new ResponseCustomerDto(
//                    selectedCustomer.get().getPublicId(),
//                    selectedCustomer.get().getName(),
//                    selectedCustomer.get().getAddress(),
//                    selectedCustomer.get().getSalary(),
//                    selectedCustomer.get().isActiveState()
//            );
//        }
//
// throw new ClassNotFoundException();
//
//    }
//
//    public static ResponseCustomerDto updateCustomer(RequestCustomerDto dto, int id) throws ClassNotFoundException {
//        Optional<CustomerDto> selectedCustomer = customerTable.stream()
//                .filter(e -> e.getPublicId() == id)
//                .findFirst();
//
//
//        if (selectedCustomer.isPresent()) {
//
//
//                    selectedCustomer.get().setName(dto.getName());
//                    selectedCustomer.get().setAddress(dto.getAddress());
//                    selectedCustomer.get().setSalary(dto.getSalary());
//
//
//            return new ResponseCustomerDto(
//                    selectedCustomer.get().getPublicId(),
//                    selectedCustomer.get().getName(),
//                    selectedCustomer.get().getAddress(),
//                    selectedCustomer.get().getSalary(),
//                    selectedCustomer.get().isActiveState()
//            );
//
//        }
//       throw new ClassNotFoundException();
//    }
//
//    public static void deleteCustomer(int id) throws ClassNotFoundException {
//        Optional<CustomerDto> selectedCustomer = customerTable.stream()
//                .filter(e -> e.getPublicId() == id)
//                .findFirst();
//
//
//        if (selectedCustomer.isPresent()) {
//            customerTable.remove(selectedCustomer.get());
//            return;
//
//        }
//        throw new ClassNotFoundException();
//    }
//
//
//    public static CustomerPaginatedDto searchAllCustomer(int page, int size, String searchText)  {
//
//        List<ResponseCustomerDto> list = new ArrayList<>();
//
//        for (CustomerDto d : customerTable) {
//            list.add(new ResponseCustomerDto(
//                    d.getPublicId(),
//                    d.getName(),
//                    d.getAddress(),
//                    d.getSalary(),
//                    d.isActiveState()
//            ));
//        }
//
//        return new CustomerPaginatedDto(customerTable.size(), list);
//
//    }
//
//
//}
