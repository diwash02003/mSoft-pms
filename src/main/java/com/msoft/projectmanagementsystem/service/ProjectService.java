package com.msoft.projectmanagementsystem.service;

import com.msoft.projectmanagementsystem.Exception.CustomException;
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

    public Project updateProject(Long id, Project updateProject) {
        return projectRepo.findById(id)
                .map(existingProject -> {
                    existingProject.setName(updateProject.getName());
                    existingProject.setDescription(updateProject.getDescription());
                    existingProject.setStartDate(updateProject.getStartDate());
                    existingProject.setStatus(updateProject.getStatus());
                    existingProject.setClient(updateProject.getClient());
                    existingProject.setCompany(updateProject.getCompany());
                    existingProject.setDueDate(updateProject.getDueDate());
                    existingProject.setUpdatedAt(updateProject.getUpdatedAt());
                    existingProject.setCreatedAt(updateProject.getCreatedAt());
                    return projectRepo.save(existingProject);
                })
                .orElseThrow(() -> new CustomException("project with id " + id + " not found"));
    }


    public boolean deleteProject(Long id) {
        if (projectRepo.existsById(id)) {
            projectRepo.deleteById(id);
            return true; // Deletion was successful
        }
        return false; // Project not found
    }
}
