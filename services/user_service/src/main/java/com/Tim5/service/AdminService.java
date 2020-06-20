package com.Tim5.service;

import com.Tim5.dao.AdminRepository;
import com.Tim5.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin save(Admin admin) {return adminRepository.save(admin);}

    public Admin findById(Long id) {return adminRepository.findById(id).orElseGet(null);}

    public Admin findByUserId(Long id) {return  adminRepository.findAdminByUserId(id);}

}
