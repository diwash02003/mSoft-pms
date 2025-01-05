package com.msoft.projectmanagementsystem.controller;

import com.msoft.projectmanagementsystem.Exception.CustomException;
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
 * REST controller for managing Super Admins and Companies.
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

    /**
     * Creates a new Super Admin or updates an existing Super Admin.
     *
     * @param superAdmin the Super Admin details to be created or updated
     * @return ResponseEntity containing the created or updated Super Admin and HTTP status
     */
    @PostMapping("/createOrUpdateAdmin")
    public ResponseEntity<SuperAdmin> createOrUpdateAdmin(@RequestBody SuperAdmin superAdmin) {
        try {

            // Validate that the password is not null or empty
            if (superAdmin.getPassword() == null || superAdmin.getPassword().isEmpty()) {
                throw new CustomException("Password must not be null or empty.");
            }
            SuperAdmin result;

            // Check if superAdminId is present (update case)
            if (superAdmin.getSuperAdminId() != null) {
                result = superAdminService.updateAdmin(superAdmin.getSuperAdminId(), superAdmin);
            } else {
                // Create new Super Admin (create case)
                result = superAdminService.createAdmin(superAdmin);
            }

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Error processing super admin information: " + e.getMessage());
        }
    }


    /**
     * Creates a new Company or updates an existing Company.
     *
     * @param company the Company details to be created or updated
     * @return ResponseEntity containing the created or updated Company and HTTP status
     */
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
            throw new CustomException("Error processing company information: " + e.getMessage());
        }
    }

    /**
     * Retrieves a list of all companies.
     *
     * @return ResponseEntity containing the list of companies or no content if empty
     */
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        if (companies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(companies);
    }

    @DeleteMapping("deleteCompany/{companyId}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long companyId) {
        try {
            boolean isDeleted = companyService.deleteCompanyById(companyId);
            if (isDeleted) {
                return ResponseEntity.ok("Company deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting company: " + e.getMessage());
        }
    }

}
