/**
 * 
 */
package com.allianz.shopping.data.dao;

import static com.allianz.shopping.util.DateUtility.convertStringToDate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.data.dao.contract.ProductDAO;
import com.allianz.shopping.data.model.Category;
import com.allianz.shopping.data.model.Product;

/**
 * @author Allianz3076
 *
 */
public class ProductDAOImpl implements ProductDAO {

	private static List<Product> products = new ArrayList<Product>();

	static {
		try {
			products.add(new Product(101, "Colgate1", "Colgate1 Tube", 50, convertStringToDate("24/05/2003")));
			products.add(new Product(102, "Colgate2", "Colgate2 Tube", 40, convertStringToDate("13/03/2004")));
			products.add(new Product(103, "Colgate3", "Colgate3 Tube", 50, convertStringToDate("02/12/2006")));
			products.add(new Product(104, "Colgate4", "Colgate4 Tube", 60, convertStringToDate("22/03/2017")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.allianz.shopping.data.dao.contract.ProductDAO#add(com.allianz.shopping.
	 * data.model.Product)
	 */
	@Override
	public boolean add(Product product) {
		return products.add(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.allianz.shopping.data.dao.contract.ProductDAO#update(com.allianz.shopping
	 * .data.model.Product)
	 */
	@Override
	public boolean update(Product productData, int id) {

		if (products != null && products.size() > 0) {

			for (int iter = 0; iter < products.size(); iter++) {

				Product productFromList = products.get(iter);
				if (productFromList.getId() == id) {
					products.set(iter, productData);
					return true;
				}

			}

		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.allianz.shopping.data.dao.contract.ProductDAO#delete(com.allianz.shopping
	 * .data.model.Product)
	 */
	@Override
	public boolean delete(Product product) {
		if (products != null && products.size() > 0) {

			for (int iter = 0; iter < products.size(); iter++) {

				Product productFromList = products.get(iter);
				if (productFromList.getId() == product.getId()) {
					products.remove(iter);
					return true;
				}

			}

		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.allianz.shopping.data.dao.contract.ProductDAO#getAll()
	 */
	@Override
	public List<Product> getAll() {
		return products;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.allianz.shopping.data.dao.contract.ProductDAO#getAllByName(java.lang.
	 * String)
	 */
	@Override
	public List<Product> getAllByName(String name) {

		if (products != null) {
			List<Product> returnProducts = new ArrayList<Product>();

			for (Product product : products)
				if (product.getName().toLowerCase().contains(name.toLowerCase()))
					returnProducts.add(product);

			return returnProducts;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.allianz.shopping.data.dao.contract.ProductDAO#getAllByPrice(float,
	 * float)
	 */
	@Override
	public List<Product> getAllByPrice(float min, float max) {
		if (products != null) {
			List<Product> returnProducts = new ArrayList<Product>();

			for (Product product : products)
				if (min <= product.getPrice() && product.getPrice() <= max)
					returnProducts.add(product);

			return returnProducts;
		}
		return null;
	}

	@Override
	public Product find(int id) {
		if (products != null && products.size() > 0)
			for (Product product : products)
				if (product.getId() == id)
					return product;

		return null;
	}

	@Override
	public List<Category> getCategoriesOfProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
