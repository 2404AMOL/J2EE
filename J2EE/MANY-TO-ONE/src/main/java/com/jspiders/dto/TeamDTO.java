package com.jspiders.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class TeamDTO {
	@Id
	private int id;
	private String name;
	private String country;
}
