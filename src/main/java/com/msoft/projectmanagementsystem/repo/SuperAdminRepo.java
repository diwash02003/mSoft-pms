package com.msoft.projectmanagementsystem.repo;

import com.msoft.projectmanagementsystem.model.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created On : 2025 03 Jan 2:41 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
@Repository
public interface SuperAdminRepo extends JpaRepository<SuperAdmin, Long> {
}
