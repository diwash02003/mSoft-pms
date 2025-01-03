package com.msoft.projectmanagementsystem.repo;

import com.msoft.projectmanagementsystem.model.CompanyAdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created On : 2025 03 Jan 2:43 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
@Repository
public interface CompanyAdminPermissionRepo extends JpaRepository<CompanyAdminPermission, Long> {
}
