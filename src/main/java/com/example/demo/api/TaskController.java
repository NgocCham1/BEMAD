package com.example.demo.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.data.TaskRepository;
import com.example.demo.model.Task;

@RestController
@RequestMapping(path = "/task", produces = "application/json")
@CrossOrigin(origins = "*")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
//	@Autowired
//	EntityLinks entityLinks;

	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@GetMapping
	public Iterable<Task> getAllTask(){
		return taskRepository.findAll();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task postTask(@RequestBody Task task) {
		
		return taskRepository.save(task);
	}
	
	@PostMapping("/edit/{id}")
	public Task updateTask(@PathVariable("id") int id, @RequestBody Task task) {
		
		return taskRepository.save(task);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTask(@PathVariable("id") int taskid) {
		taskRepository.deleteById(taskid);
	}
	
	@GetMapping("/state/{state}")
	public Iterable<Task> getAllTaskByState(@PathVariable("state") String state){
		return taskRepository.getAllTaskByState(state);
	}
	
	@GetMapping("/project/{project}")
	public Iterable<Task> getAllTaskByProject(@PathVariable("project") String project){
		return taskRepository.getAllTaskByProject(project);
	}
}
