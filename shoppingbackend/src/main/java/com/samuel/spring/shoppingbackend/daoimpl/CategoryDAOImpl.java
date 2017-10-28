package com.samuel.spring.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.samuel.spring.shoppingbackend.dao.CategoryDAO;
import com.samuel.spring.shoppingbackend.dto.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static  List<Category> categories= new ArrayList<Category>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Description for Television");
		category.setImageURL("CAT1_1.png");
		
		categories.add(category);

		//second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description for Mobile");
		category.setImageURL("CAT1_2.png");
		
		categories.add(category);
		
		//third Category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageURL("CAT1_3.png");
		
		categories.add(category);


	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		for(Category category: categories) {
			if(category.getId()==id)
				return category;
		}
		return null;
	}

}
