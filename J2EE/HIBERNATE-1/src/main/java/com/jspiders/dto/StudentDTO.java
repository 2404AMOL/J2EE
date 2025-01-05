package com.jspiders.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StudentDTO {
	@Id
	private int id;
	private String name;
	private int age;
	private long contact;
	private double fees;
	private String address;
	
}
