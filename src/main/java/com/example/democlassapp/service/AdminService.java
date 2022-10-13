package com.example.democlassapp.service;

import com.example.democlassapp.entity.Admin;
import java.util.List;

public interface AdminService {
    public List<Admin> findAll();
    public Admin findById(int id);
    public void save(Admin admin);
    public void deleteById(int id);
}
