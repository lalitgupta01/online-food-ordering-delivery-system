package com.onlinefood.dto;	

import java.util.List;

import com.onlinefood.entities.CustomerAddress;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerRespDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile_no;
	private List<CustomerAddress> addrList; 
	
}
