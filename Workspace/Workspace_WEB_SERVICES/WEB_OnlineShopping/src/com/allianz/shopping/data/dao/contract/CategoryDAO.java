package com.allianz.shopping.data.dao.contract;

import java.util.List;

import com.allianz.shopping.data.model.Category;
import com.allianz.shopping.data.model.Product;

public interface CategoryDAO {
	public boolean add(Category category);

	public boolean update(Category categoryData, int id);

	public boolean delete(Category category);

	public List<Category> getAll();

	public List<Category> getAllByCode(String code);

	public Category find(int id);
	
	public List<Product> getProductsOfCategory(Category category);
}
