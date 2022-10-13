package com.example.democlassapp.restcontroller;

import com.example.democlassapp.entity.Admin;
import com.example.democlassapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminRestController {
    private AdminService adminService;
    @Autowired
    public AdminRestController(AdminService adminService){
        this.adminService=adminService;
    }
    @GetMapping("/admins")
    public List<Admin> findAll(){
        return adminService.findAll();
    }

    @GetMapping("admins/{adminId}")
    public Admin findById(@PathVariable int adminId){
        Admin admin=adminService.findById(adminId);
        if(admin==null){
            throw new RuntimeException("admin id not found"+adminId);
        }
        return admin;

    }
    @PostMapping("/admins")
    public Admin addAmin(@RequestBody Admin admin){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        admin.setId(0);
        adminService.save(admin);
        return admin;
    }

    @PutMapping("/admins")
    public Admin updateAdmin(@RequestBody Admin admin){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        adminService.save(admin);
        return admin;
    }

    @DeleteMapping("/admins/{adminId}")
    public String deleteAdmin(@PathVariable int adminId){
        Admin admin=adminService.findById(adminId);
        if(admin==null){
            throw new RuntimeException("this admin isn't in our system");
        }
        adminService.deleteById(adminId);
        return "the admin was deleted successfully! "+adminId;
    }
}
