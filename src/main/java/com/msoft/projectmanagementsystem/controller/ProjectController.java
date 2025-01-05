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


    //to create a new Project in the company
    @PostMapping()
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        try {
            Project newProject = projectService.addProject(project);
            return new ResponseEntity<>(newProject, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new CustomException("Error creating project: " + e.getMessage());
        }
    }

    //to fetch the all project
    @GetMapping()
    public ResponseEntity<List<Project>> getAllProjects() {

        List<Project> projects = projectService.getProjects();
        return projects != null ? ResponseEntity.ok(projects) : ResponseEntity.notFound().build();
    }


    //to fetch the project with their respective projectId
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return project != null ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
    }


    //to update the project details with the help of projectId
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateSuperAdmin(@PathVariable Long id, @RequestBody Project updateProject) {
        try {
            Project project = projectService.updateProject(id, updateProject);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Error Updating project" + e.getMessage());
        }
    }



    //to delete the whole project  by the database
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        boolean isDeleted = projectService.deleteProject(id);
        if (isDeleted) {
            return ResponseEntity.ok("Project deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found.");
        }
    }




}
