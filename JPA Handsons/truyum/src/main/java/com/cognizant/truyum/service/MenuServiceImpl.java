package com.cognizant.truyum.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.truyum.model.Menu;
import com.cognizant.truyum.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	MenuRepository repo;

	@Transactional
	@Override
	public List<Menu> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		List<Menu> menu = repo.findAll();
		return menu;
	}

	@Transactional
	@Override
	public List<Menu> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<Menu> menu = repo.findAll();
		return menu;
	}

	@Transactional
	@Override
	public Menu getMenuItem(int id) {
		// TODO Auto-generated method stub
		Optional<Menu> menuItem = repo.findById(id);
		Menu menu = menuItem.get();
		return menu;
	}

	@Transactional
	@Override
	public void editMenuItem(Menu menu) {
		// TODO Auto-generated method stub
		
		Optional<Menu> item = repo.findById(menu.getId());
		Menu res = item.get();
		res.setName(menu.getName());
		res.setDate(menu.getDate());
		res.setActive(menu.isActive());
		res.setCategory(menu.getCategory());
		res.setPrice(menu.getPrice());
		res.setDelivery(menu.isDelivery());
		repo.save(res);
	}
}
