package com.msoft.projectmanagementsystem.service;

import com.msoft.projectmanagementsystem.model.Project;
import com.msoft.projectmanagementsystem.repo.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created On : 2025 05 Jan 12:15 PM
 * Author : Monu Siddiki
 * Description :
 **/
@Service
public class ProjectService {

    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }
}
