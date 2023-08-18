package com.onlinefood.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefood.custom_exceptions.ApiException;
import com.onlinefood.custom_exceptions.ResourceNotFoundException;
import com.onlinefood.dto.CustomerAddAddressDTO;
import com.onlinefood.dto.CustomerAddDTO;
import com.onlinefood.entities.CustomerAddress;
import com.onlinefood.repository.AddressRepo;
import com.onlinefood.repository.CustomerRepo;
import com.onlinefood.entities.Customer;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomerRepo customerDao;
	
	@Autowired
	private AddressRepo addressDao;
	
	@Override
	public CustomerAddDTO addNewCustomer(CustomerAddDTO cDto) {
		if (cDto.getConfirmPassword().equals(cDto.getPassword())) {
			Customer customer = mapper.map(cDto, Customer.class);
			Customer persistentCustomer = customerDao.save(customer);
			return mapper.map(persistentCustomer, CustomerAddDTO.class);
		} else
			throw new ApiException("Passwords don't match!!!!!");
	}
	
	@Override
	public void addAddressToCustomer(Long customerId, CustomerAddAddressDTO address) {
		  Customer customer = customerDao.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !!!!"));
		  CustomerAddress addr = mapper.map(address, CustomerAddress.class);
		  customer.addAddress(addr);
	      addressDao.save(addr);	
	}
	
}
