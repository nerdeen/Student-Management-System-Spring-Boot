package com.example.democlassapp.service;

import com.example.democlassapp.dao.AdminRepository;
import com.example.democlassapp.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl (AdminRepository adminRepository){
    this.adminRepository=adminRepository;
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(int id) {
        Optional<Admin> result = adminRepository.findById(id);
        Admin admin=null;
        if(result.isPresent()){
           admin=result.get();
        }
        return admin;
    }

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteById(int id) {
        adminRepository.deleteById(id);
    }
}
