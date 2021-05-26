package com.example.demo.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ProjectRepository;
import com.example.demo.model.Project;

@RestController
@RequestMapping(path = "/project", produces = "application/json")
@CrossOrigin(origins = "*")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;
	
//	@Autowired
//	EntityLinks entityLinks;

	public ProjectController(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	@GetMapping
	public Iterable<Project> getAllProject(){
		return projectRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Project postProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
}
