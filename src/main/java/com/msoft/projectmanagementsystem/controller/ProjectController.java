package com.msoft.projectmanagementsystem.controller;

import com.msoft.projectmanagementsystem.Exception.CustomException;
import com.msoft.projectmanagementsystem.model.Project;
import com.msoft.projectmanagementsystem.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created On : 2025 05 Jan 11:56 AM
 * Author : Monu Siddiki
 * Description :
 **/
@RestController
@RequestMapping("project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping()
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        try {
            Project newProject = projectService.addProject(project);
            return new ResponseEntity<>(newProject, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new CustomException("Error creating project: " + e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<Project>> getAllProjects() {

        List<Project> projects = projectService.getProjects();
        return projects != null ? ResponseEntity.ok(projects) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return project != null ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
    }




}
