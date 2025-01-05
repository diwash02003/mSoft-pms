package com.msoft.projectmanagementsystem.service;

import com.msoft.projectmanagementsystem.model.Company;
import com.msoft.projectmanagementsystem.repo.CompanyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created On:1/2/25 5:29 PM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
@Service
public class CompanyService {
    private final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public Company createCompany(Company company) {
        return companyRepo.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }
}
