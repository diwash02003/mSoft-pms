package com.msoft.projectmanagementsystem.repo;

import com.msoft.projectmanagementsystem.model.GlobalCompanyPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created On : 2025 03 Jan 2:42 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
@Repository
public interface GlobalCompanyPermissionRepo extends JpaRepository<GlobalCompanyPermission, Long> {
}
