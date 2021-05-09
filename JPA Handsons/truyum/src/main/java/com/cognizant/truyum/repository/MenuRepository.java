package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cognizant.truyum.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
	@Query("select m from Menu m where m.active=true and m.date <= sysdate()")
	List<Menu> getMenuItemListCustomer();

}
