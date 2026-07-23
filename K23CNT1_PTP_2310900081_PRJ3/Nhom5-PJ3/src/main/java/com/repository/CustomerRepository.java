package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Tìm khách hàng theo Email
    Customer findByEmail(String email);

    // Kiểm tra Email đã tồn tại hay chưa
    boolean existsByEmail(String email);

    // Tìm theo họ tên (không phân biệt hoa thường)
    List<Customer> findByFullNameContainingIgnoreCase(String fullName);

}