package com.msoft.projectmanagementsystem.repo;

import com.msoft.projectmanagementsystem.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created On : 2025 05 Jan 12:18 PM
 * Author : Monu Siddiki
 * Description :
 **/
@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
}
