package com.msoft.projectmanagementsystem.controller;

import com.msoft.projectmanagementsystem.Exception.CustomException;
import com.msoft.projectmanagementsystem.model.Project;
import com.msoft.projectmanagementsystem.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("addProject")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        try {
            Project project = projectService.addProject(project)
            return new ResponseEntity<>(project, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new customException("Error creating project: " + e.getMessage());
        }
    }




}
