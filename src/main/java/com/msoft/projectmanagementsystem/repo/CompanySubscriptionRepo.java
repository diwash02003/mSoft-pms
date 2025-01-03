package com.msoft.projectmanagementsystem.repo;

import com.msoft.projectmanagementsystem.model.CompanySubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created On : 2025 03 Jan 2:50 PM
 * Author : Monu Siddiki
 * Description :
 **/
@Repository
public interface CompanySubscriptionRepo extends JpaRepository<CompanySubscription, Long> {
}
