package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
	@Query("SELECT t FROM Task t WHERE project_id = ?1")
	public Iterable<Task> getAllTaskByProject(@Param("projectId") String projectId);
	@Query("SELECT t FROM Task t WHERE state = 'DONE' AND project_id = ?1")
	public Iterable<Task> getAllTaskByState(@Param("state") String state);
}
