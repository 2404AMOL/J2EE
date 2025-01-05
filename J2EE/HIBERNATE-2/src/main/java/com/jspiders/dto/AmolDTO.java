package com.jspiders.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AmolDTO {
	
	@Id
	private int id;
	private String name;
	private byte image;
	

}
