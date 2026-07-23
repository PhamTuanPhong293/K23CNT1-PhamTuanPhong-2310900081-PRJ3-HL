package com.service;

import java.util.List;

import com.model.Customer;

public interface CustomerService {

    // Lấy danh sách khách hàng
    List<Customer> getAllCustomers();

    // Lấy khách hàng theo ID
    Customer getCustomerById(Long id);

    // Thêm hoặc cập nhật khách hàng
    Customer saveCustomer(Customer customer);

    // Xóa khách hàng theo ID
    void deleteCustomer(Long id);

}