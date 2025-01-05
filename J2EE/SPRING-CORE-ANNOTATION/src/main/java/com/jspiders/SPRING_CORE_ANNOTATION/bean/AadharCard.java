package com.jspiders.SPRING_CORE_ANNOTATION.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AadharCard {

	@org.springframework.beans.factory.annotation.Value("1")
	private long id;
	@org.springframework.beans.factory.annotation.Value("931300905827")
	private long aadharNumber;
}
