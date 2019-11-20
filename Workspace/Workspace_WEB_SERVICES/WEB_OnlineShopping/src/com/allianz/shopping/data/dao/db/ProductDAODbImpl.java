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

import com.allianz.shopping.data.dao.contract.ProductDAO;
import com.allianz.shopping.data.dao.db.support.DBDao;
import com.allianz.shopping.data.model.Category;
import com.allianz.shopping.data.model.Product;
import com.allianz.shopping.support.database.querybuilder.SqlQueryBuilder;
import com.allianz.shopping.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
import com.allianz.shopping.support.database.querybuilder.sql.support.SqlQuery;
import com.allianz.shopping.support.database.querybuilder.sql.support.SqlQueryCondition;
import com.allianz.shopping.support.database.querybuilder.sql.support.flags.SqlQueryBuilderFlags;
import com.allianz.shopping.util.DateUtility;

/**
 * @author Allianz3076
 *
 */
public class ProductDAODbImpl extends DBDao implements ProductDAO {
	
	private String categoryPivotTableName;
	
	public String getCategoryPivotTableName() {
		return categoryPivotTableName;
	}

	public void setCategoryPivotTableName(String categoryPivotTableName) {
		this.categoryPivotTableName = categoryPivotTableName;
	}

	public ProductDAODbImpl() throws ClassNotFoundException, SQLException {
		super();
		setTableName("products");
		setCategoryPivotTableName("products_categories");
	}

	public static Product buildProductFromResultSet(ResultSet rs) throws SQLException {
		return new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"),
				DateUtility.convertSqlDateToUtilDate(rs.getDate("manufactureDate")));
	}

	@Override
	public boolean add(Product product) {
		List<String> columns = Arrays.asList("name", "description", "price", "manufactureDate");
		List<Object> values = Arrays.asList(product.getName(), product.getDescription(), product.getPrice(),
				DateUtility.convertUtilDateToSqlDate(product.getManufactureDate()).toString());

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
	public boolean update(Product productData, int id) {
		Map<String, Object> values = new HashMap<String, Object>();

		values.put("name", productData.getName());
		values.put("description", productData.getDescription());
		values.put("price", productData.getPrice());
		values.put("manufactureDate",
				DateUtility.convertUtilDateToSqlDate(productData.getManufactureDate()).toString());

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
	public boolean delete(Product product) {
		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_EQUAL, product.getId()));

		try {
			String query = new SqlQueryBuilder(getTableName()).delete(conditions);
			return getDatabaseManager().createStatement().executeUpdate(query) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();

		String query = new SqlQueryBuilder(getTableName()).select(null);

		try {
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			while (rs.next()) {
				Product product = buildProductFromResultSet(rs);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return products;
	}

	@Override
	public List<Product> getAllByName(String name) {
		List<Product> products = new ArrayList<Product>();

		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("name", SqlQueryBuilderFlags.CONDITION_LIKE, name));

		String query = new SqlQueryBuilder(getTableName()).select(null, conditions);

		try {
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			while (rs.next()) {
				Product product = buildProductFromResultSet(rs);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return products;
	}

	@Override
	public List<Product> getAllByPrice(float min, float max) {
		List<Product> products = new ArrayList<Product>();

		List<SqlQueryCondition> conditions = Arrays.asList(
				new SqlQueryCondition("price", SqlQueryBuilderFlags.CONDITION_GREATER_THAN_OR_EQUAL, min),
				new SqlQueryCondition(SqlQueryBuilderFlags.CONDITION_JOINER_AND),
				new SqlQueryCondition("price", SqlQueryBuilderFlags.CONDITION_LESS_THAN_OR_EQUAL, max));

		String query = new SqlQueryBuilder(getTableName()).select(null, conditions);

		try {
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			while (rs.next()) {
				Product product = buildProductFromResultSet(rs);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return products;
	}

	@Override
	public Product find(int id) {

		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_EQUAL, id));

		String query = new SqlQueryBuilder(getTableName()).select_limited(null, conditions, 1);

		try {
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			rs.next();

			return buildProductFromResultSet(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Category> getCategoriesOfProduct(Product product) {
		List<Category> categories = new ArrayList<Category>();

		List<String> categoryIdColumns = Arrays.asList("category_id");
		List<SqlQueryCondition> categoryIdConditions = Arrays
				.asList(new SqlQueryCondition("product_id", SqlQueryBuilderFlags.CONDITION_EQUAL, product.getId()));

		String categoryIdQueryString = new SqlQueryBuilder(getCategoryPivotTableName()).select(categoryIdColumns, categoryIdConditions);
		
		SqlQuery categoryIdQuery = new SqlQuery(categoryIdQueryString);
		
		List<SqlQueryCondition> productConditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_IN, categoryIdQuery));

		try {
			String query = new SqlQueryBuilder(new CategoryDAODbImpl().getTableName()).select(null, productConditions);
			
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			while (rs.next()) {
				Category category = CategoryDAODbImpl.buildCategoryFromResultSet(rs);
				categories.add(category);
			}
			return categories;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
		
	}

}
