package com.jspiders.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
@Data
@Entity

public class StudentsDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,unique = true)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	private int age;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<CoursesDTO> coursesDTOs;
	
}
