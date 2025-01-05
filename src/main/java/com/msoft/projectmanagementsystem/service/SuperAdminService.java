package com.msoft.projectmanagementsystem.service;

import com.msoft.projectmanagementsystem.model.Company;
import com.msoft.projectmanagementsystem.model.SuperAdmin;
import com.msoft.projectmanagementsystem.repo.CompanyRepo;
import com.msoft.projectmanagementsystem.repo.SuperAdminRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created On:1/2/25 5:28 PM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
@Service
public class SuperAdminService {
    private final SuperAdminRepo superAdminRepo;
    private final CompanyRepo companyRepo;

    public SuperAdminService(SuperAdminRepo superAdminRepo, CompanyRepo companyRepo) {
        this.superAdminRepo = superAdminRepo;
        this.companyRepo = companyRepo;
    }

    public SuperAdmin createAdmin(SuperAdmin superAdmin) {
        return superAdminRepo.save(superAdmin);
    }

    public Company createCompany(Company company) {
        return companyRepo.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }
}
