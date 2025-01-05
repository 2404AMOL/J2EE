package com.jspiders.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class StudentDTO {

	@Id
	int id;
	private String name;
	private int age;
	private long contact;
	private double fees;
	private String address;
}
