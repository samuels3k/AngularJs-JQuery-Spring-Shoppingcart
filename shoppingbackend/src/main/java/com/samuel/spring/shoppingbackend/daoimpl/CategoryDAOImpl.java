package com.samuel.spring.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.samuel.spring.shoppingbackend.dao.CategoryDAO;
import com.samuel.spring.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		String selectActiveCategory="From Category WHERE active= :active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	} 

	/**
	 * getting single category based on id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/**
	 * Updating single category
	 */
	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		try {
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
