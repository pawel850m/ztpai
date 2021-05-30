package com.example.ztpai.controller;

import com.example.ztpai.dto.ProjectRequest;
import com.example.ztpai.dto.ProjectResponse;
import com.example.ztpai.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/v1/project")
@CrossOrigin
public class ProjectController {

    final private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectResponse>> findAllProjects() {
        return ResponseEntity.ok(projectService.findAllProjects());
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectResponse> addProject(@RequestBody ProjectRequest project){
        return status(HttpStatus.OK).body(projectService.addProject(project));
    }

    @GetMapping("/close/{id}")
    public ResponseEntity<?> closeProject(@PathVariable("id") Long projectId){
        projectService.closeProject(projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long projectId){
        projectService.deleteProject(projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ProjectResponse> updateProject(@RequestBody ProjectRequest projectRequest){
        return new ResponseEntity<>(projectService.updateProject(projectRequest), HttpStatus.CREATED);
    }
}
