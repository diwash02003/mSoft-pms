package com.msoft.projectmanagementsystem.controller;

import com.msoft.projectmanagementsystem.Exception.customException;
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
            throw new customException("Error creating superAdmin: " + e.getMessage());
        }
    }

    @PutMapping("{/id}")
    public ResponseEntity<SuperAdmin> updateSuperAdmin(@PathVariable Long id, @RequestBody SuperAdmin updateSuperAdmin) {
        try {
            SuperAdmin admin = superAdminService.updateAdmin(id, updateSuperAdmin);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (Exception e) {
            throw new customException("Error Updating super admin" + e.getMessage());
        }
    }


    @PostMapping("/createOrUpdateCompany")
    public ResponseEntity<Company> createOrUpdateCompany(@RequestBody Company company) {
        try {
            Company result;
            if (company.getCompanyId() != null) {
                result = companyService.updateCompany(company.getCompanyId(), company);
            } else {
                result = companyService.createCompany(company);
            }
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new customException("Error processing company information: " + e.getMessage());
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
