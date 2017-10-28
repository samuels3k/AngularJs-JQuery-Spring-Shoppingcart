package com.samuel.spring.shoppingbackend.dao;

import java.util.List;

import com.samuel.spring.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);
}
