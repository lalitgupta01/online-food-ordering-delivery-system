package com.onlinefood.dto;

import com.onlinefood.entities.Category;
import com.onlinefood.entities.MenuType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class GetMenuDTO {
	private Long id;

	private String name;

	private MenuType menuType;

	private Category category;

	private double price;

	private int rating;

}
