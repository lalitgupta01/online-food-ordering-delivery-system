package com.onlinefood.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefood.dto.CustomerAddAddressDTO;
import com.onlinefood.dto.CustomerAddDTO;
import com.onlinefood.service.CustomerService;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<?> addNewDept(@RequestBody @Valid CustomerAddDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addNewCustomer(dto));
	}

	@PostMapping("/{customerId}/addresses")
	public ResponseEntity<String> addAddressToCustomer(@PathVariable Long customerId, @RequestBody CustomerAddAddressDTO address) {
		customerService.addAddressToCustomer(customerId, address);
		return ResponseEntity.ok("Address added to customer.");
	}

}
