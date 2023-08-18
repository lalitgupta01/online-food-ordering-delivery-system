package com.onlinefood.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cart extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name = "order_timestamp")
	private LocalDateTime orderTimestamp;
	
	@Column
	private boolean placed;
	
}
