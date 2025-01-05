package com.jspiders.SPRING_CORE_ANNOTATION.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component(value ="personBean")
@Data
public class Person {

	@Value("1")
	private long id;
	@Value("Ramesh")
	private String name;
	@Value("9373428581")
	private long contact;
	@Autowired
	private AadharCard aadharCard;
}
