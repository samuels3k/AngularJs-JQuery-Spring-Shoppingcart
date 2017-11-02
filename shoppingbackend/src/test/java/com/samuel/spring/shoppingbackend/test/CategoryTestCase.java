package com.samuel.spring.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.samuel.spring.shoppingbackend.dao.CategoryDAO;
import com.samuel.spring.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static  AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.samuel.spring.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageURL("CAT1_105.png");
		
		assertEquals("Successfully added a category inside the table",true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(2);
		assertEquals("Successfully fetche a single category frome the table","Laptop", category.getName());
	}*/

	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(1);
		category.setName("T V");
		assertEquals("Successfully Updated a single category in the table",true, categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(1);
		assertEquals("Successfully Updated a single category in the table",true, categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory() {
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched list category from the table",1, categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory() {
		category = new Category();
		category.setName("Mobile");
		category.setDescription("Description for Mobile");
		category.setImageURL("CAT1_1.png");
		
		assertEquals("Successfully added a category inside the table",true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("Description for Television");
		category.setImageURL("CAT1_2.png");
		
		assertEquals("Successfully added a category inside the table",true, categoryDAO.add(category));
		
		//fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully Updated a single category in the table",true, categoryDAO.update(category));
	
		//delete the category
		
		assertEquals("Successfully Updated a single category in the table",true, categoryDAO.delete(category));
		
		//fetching the list
		
		assertEquals("Successfully fetched list category from the table",1, categoryDAO.list().size());
		
	}
}
