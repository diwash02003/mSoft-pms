package com.msoft.projectmanagementsystem.repo;

import com.msoft.projectmanagementsystem.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created On:1/3/25 2:39 PM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
}
