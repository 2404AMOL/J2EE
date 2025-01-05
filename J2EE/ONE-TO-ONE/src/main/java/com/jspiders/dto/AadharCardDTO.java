package com.jspiders.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AadharCardDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	long aadharNum;
}
