package com.msoft.projectmanagementsystem.repo;

import com.msoft.projectmanagementsystem.model.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created On : 2025 03 Jan 2:51 PM
 * Author : Monu Siddiki
 * Description :
 **/
@Repository
public interface SystemSettingRepo extends JpaRepository<SystemSetting, Long> {
}
