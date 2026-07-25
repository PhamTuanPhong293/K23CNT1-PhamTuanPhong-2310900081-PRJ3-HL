package com.repository;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Tìm User theo Username
    User findByUsername(String username);

    // Kiểm tra Username đã tồn tại hay chưa
    boolean existsByUsername(String username);

    // Đăng nhập
    User findByUsernameAndPassword(String username, String password);

}