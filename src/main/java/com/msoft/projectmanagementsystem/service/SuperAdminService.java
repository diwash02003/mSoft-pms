package com.msoft.projectmanagementsystem.service;

import com.msoft.projectmanagementsystem.model.SuperAdmin;
import com.msoft.projectmanagementsystem.repo.SuperAdminRepo;
import org.springframework.stereotype.Service;

/**
 * Created On:1/2/25 5:28 PM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
@Service
public class SuperAdminService {
    private final SuperAdminRepo superAdminRepo;

    public SuperAdminService(SuperAdminRepo superAdminRepo) {
        this.superAdminRepo = superAdminRepo;
    }

    public SuperAdmin createAdmin(SuperAdmin superAdmin) {
        return superAdminRepo.save(superAdmin);
    }

}
