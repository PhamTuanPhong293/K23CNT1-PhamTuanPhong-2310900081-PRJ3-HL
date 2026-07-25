package com.service;

import com.model.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getAllStaff();

    Staff getStaffById(Long id);

    Staff saveStaff(Staff staff);

    void deleteStaff(Long id);

}