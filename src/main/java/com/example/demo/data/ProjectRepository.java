package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
