/**
 * 
 */
package com.allianz.shopping.data.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.allianz.shopping.data.dao.contract.CategoryDAO;
import com.allianz.shopping.data.dao.db.support.DBDao;
import com.allianz.shopping.data.model.Category;
import com.allianz.shopping.data.model.Product;
import com.allianz.shopping.support.database.querybuilder.SqlQueryBuilder;
import com.allianz.shopping.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
import com.allianz.shopping.support.database.querybuilder.sql.support.SqlQuery;
import com.allianz.shopping.support.database.querybuilder.sql.support.SqlQueryCondition;
import com.allianz.shopping.support.database.querybuilder.sql.support.flags.SqlQueryBuilderFlags;

/**
 * @author Allianz3076
 *
 */
public class CategoryDAODbImpl extends DBDao implements CategoryDAO {

	private String productPivotTableName;

	public CategoryDAODbImpl() throws ClassNotFoundException, SQLException {
		super();
		setTableName("categories");
		setProductPivotTableName("products_categories");
	}

	public static Category buildCategoryFromResultSet(ResultSet rs) throws SQLException {
		return new Category(rs.getInt("id"), rs.getString("code"), rs.getString("description"));
	}

	@Override
	public boolean add(Category category) {
		List<String> columns = Arrays.asList("code", "description");
		List<Object> values = Arrays.asList(category.getCode(), category.getDescription());

		String query;
		try {
			query = new SqlQueryBuilder(getTableName()).insert(values, columns);
			return getDatabaseManager().createStatement().executeUpdate(query) > 0;
		} catch (InvalidQueryBuilderParameter | SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category categoryData, int id) {
		Map<String, Object> values = new HashMap<String, Object>();

		values.put("name", categoryData.getCode());
		values.put("description", categoryData.getDescription());

		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_EQUAL, id));

		try {
			String query = new SqlQueryBuilder(getTableName()).update(values, conditions);
			return getDatabaseManager().createStatement().executeUpdate(query) > 0;
		} catch (InvalidQueryBuilderParameter | SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {
		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_EQUAL, category.getId()));

		try {
			String query = new SqlQueryBuilder(getTableName()).delete(conditions);
			return getDatabaseManager().createStatement().executeUpdate(query) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();

		String query = new SqlQueryBuilder(getTableName()).select(null);

		try {
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			while (rs.next()) {
				Category category = buildCategoryFromResultSet(rs);
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return categories;
	}

	@Override
	public List<Category> getAllByCode(String name) {
		List<Category> categories = new ArrayList<Category>();

		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("name", SqlQueryBuilderFlags.CONDITION_LIKE, name));

		String query = new SqlQueryBuilder(getTableName()).select(null, conditions);

		try {
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			while (rs.next()) {
				Category category = buildCategoryFromResultSet(rs);
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return categories;
	}

	@Override
	public Category find(int id) {

		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_EQUAL, id));

		String query = new SqlQueryBuilder(getTableName()).select_limited(null, conditions, 1);

		try {
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			rs.next();

			return buildCategoryFromResultSet(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Product> getProductsOfCategory(Category category) {
		List<Product> products = new ArrayList<Product>();

		List<String> productIdColumns = Arrays.asList("product_id");
		List<SqlQueryCondition> productIdConditions = Arrays
				.asList(new SqlQueryCondition("category_id", SqlQueryBuilderFlags.CONDITION_EQUAL, category.getId()));

		String productIdQueryString = new SqlQueryBuilder(getProductPivotTableName()).select(productIdColumns, productIdConditions);
		
		SqlQuery productIdQuery = new SqlQuery(productIdQueryString);
		
		List<SqlQueryCondition> productConditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_IN, productIdQuery));

		try {
			String query = new SqlQueryBuilder(new ProductDAODbImpl().getTableName()).select(null, productConditions);
			
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			while (rs.next()) {
				Product product = ProductDAODbImpl.buildProductFromResultSet(rs);
				products.add(product);
				
			}
			return products;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
		
	}

	public String getProductPivotTableName() {
		return productPivotTableName;
	}

	public void setProductPivotTableName(String productPivotTableName) {
		this.productPivotTableName = productPivotTableName;
	}

}
