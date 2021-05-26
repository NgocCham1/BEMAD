package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	public String title;
	public String description;
	public String state;
	public String tag;
	public int projectId;
	public String deadline;
}
