package com.onlinefood.repository;




import org.springframework.data.jpa.repository.JpaRepository;


import com.onlinefood.entities.Menu;

import java.util.List;


public interface MenuRepo extends JpaRepository<Menu, Long> {
	List<Menu> findByRestaurantId(Long restaurantId);
   
}
