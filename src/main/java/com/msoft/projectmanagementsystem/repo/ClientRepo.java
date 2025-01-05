package com.msoft.projectmanagementsystem.repo;

import com.msoft.projectmanagementsystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created On:1/5/25 11:55 AM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    @Query("SELECT c FROM Client c WHERE c.company.companyId = :companyId")
    List<Client> getClientsByCompanyId(@Param("companyId") Long companyId);
}
