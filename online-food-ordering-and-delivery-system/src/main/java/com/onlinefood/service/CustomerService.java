package com.onlinefood.service;

import com.onlinefood.dto.CustomerAddAddressDTO;
import com.onlinefood.dto.CustomerAddDTO;



public interface CustomerService {
	CustomerAddDTO addNewCustomer(CustomerAddDTO c);
	void addAddressToCustomer(Long customerId, CustomerAddAddressDTO address);
	
}
