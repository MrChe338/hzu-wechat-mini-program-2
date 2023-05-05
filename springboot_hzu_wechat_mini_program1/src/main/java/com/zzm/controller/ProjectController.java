package com.zzm.controller;


import com.zzm.dto.ProjectDto;

import com.zzm.pojo.project.Project;
import com.zzm.pojo.project.ProjectAndMembers;
import com.zzm.pojo.project.ProjectDto1;
import com.zzm.pojo.project.ProjectMember;
import com.zzm.service.project.ProjectMemberService;
import com.zzm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<List<Project>> getProjectListWithMembers() {
        List<Project> projectDtoList = projectService.getProjectListWithMembers();
        return new ResponseEntity<>(projectDtoList, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Project> saveProject(@RequestBody ProjectDto1 projectDto) {
        Project savedProject = projectService.saveProject(projectDto);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }
//    @GetMapping("/search")
//    public ResponseEntity<List<Project>> searchProjects() {
//        List<Project> projects = projectService.searchProjects(param);
//        return ResponseEntity.ok(projects);
//    }
    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjects(
            @RequestParam("query") String param) {
        String projectName=param;
        String nickname=param;

        List<Project> projects = projectService.searchProjects(projectName, nickname);
        return ResponseEntity.ok(projects);
    }
    @GetMapping("/by-create-time")
    public ResponseEntity<List<Project>> getProjectsOrderByCreateTime() {
        List<Project> projects = projectService.getProjectsOrderByCreateTime();
        return ResponseEntity.ok(projects);
    }
    @GetMapping("/by-popularity")
    public ResponseEntity<List<Project>> getProjectsOrderByPopularity() {
        List<Project> projects = projectService.getProjectsOrderByPopularity();
        return ResponseEntity.ok(projects);
    }
}


