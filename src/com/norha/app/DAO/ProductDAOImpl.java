package com.norha.app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.norha.app.entity.Product;


public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Product> getProducts() {
		
		/* Getting session object from the Session Factory */
		Session currentSession = sessionFactory.getCurrentSession();
		
		/* Creating Query */
		Query<Product> theQuery = currentSession.createQuery("from products", Product.class);
		
		/* Getting List Of Products */
		List<Product> products = theQuery.getResultList();

		return products;
	}

}
