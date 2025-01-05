package com.msoft.projectmanagementsystem.service;

import com.msoft.projectmanagementsystem.Exception.customException;
import com.msoft.projectmanagementsystem.model.SuperAdmin;
import com.msoft.projectmanagementsystem.repo.SuperAdminRepo;
import org.springframework.stereotype.Service;

/**
 * Created On:1/2/25 5:28 PM
 * Author: Diwash Kumar Pokhrel
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

    public SuperAdmin updateAdmin(Long id, SuperAdmin updatedSuperAdmin) {
        return superAdminRepo.findById(id)
                .map(existingAdmin -> {
                    existingAdmin.setFullName(updatedSuperAdmin.getFullName());
                    existingAdmin.setEmail(updatedSuperAdmin.getEmail());
                    existingAdmin.setPassword(updatedSuperAdmin.getPassword());
                    return superAdminRepo.save(existingAdmin);
                })
                .orElseThrow(() -> new customException("SuperAdmin with id " + id + " not found"));
    }

}

