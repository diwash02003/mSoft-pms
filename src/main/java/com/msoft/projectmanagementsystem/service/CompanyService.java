package com.msoft.projectmanagementsystem.service;

import com.msoft.projectmanagementsystem.Exception.CustomException;
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

    public Company updateCompany(Long id, Company updatedCompany) {
        return companyRepo.findById(id)
                .map(existingCompany -> {
                    existingCompany.setCompanyName(updatedCompany.getCompanyName());
                    existingCompany.setAddress(updatedCompany.getAddress());
                    existingCompany.setEmail(updatedCompany.getEmail());
                    // Update other fields as needed
                    return companyRepo.save(existingCompany);
                })
                .orElseThrow(() -> new CustomException("Company with id " + id + " not found"));
    }

}
