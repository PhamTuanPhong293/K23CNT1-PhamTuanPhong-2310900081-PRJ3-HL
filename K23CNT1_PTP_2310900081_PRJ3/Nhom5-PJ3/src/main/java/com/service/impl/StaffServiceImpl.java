package com.service.impl;

import com.model.Staff;
import com.repository.StaffRepository;
import com.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}