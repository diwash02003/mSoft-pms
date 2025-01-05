package com.msoft.projectmanagementsystem.controller;

import com.msoft.projectmanagementsystem.model.Company;
import com.msoft.projectmanagementsystem.model.SuperAdmin;
import com.msoft.projectmanagementsystem.service.CompanyService;
import com.msoft.projectmanagementsystem.service.SuperAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created On : 2025 03 Jan 3:02 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
@RestController
@RequestMapping("/superadmin")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    private final CompanyService companyService;


    public SuperAdminController(SuperAdminService superAdminService, CompanyService companyService) {
        this.superAdminService = superAdminService;
        this.companyService = companyService;
    }

    @PostMapping()
    public ResponseEntity<SuperAdmin> createAdmin(@RequestBody SuperAdmin superAdmin) {
        try {
            SuperAdmin admin = superAdminService.createAdmin(superAdmin);
            return new ResponseEntity<>(admin, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new SuperAdminException("Error creating superAdmin: " + e.getMessage());
        }
    }

    @PostMapping("/createCompany")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        try {
            Company createdCompany = companyService.createCompany(company);
            return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new SuperAdminException("Error creating company: " + e.getMessage());
        }
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        if (companies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(companies);
    }

}
