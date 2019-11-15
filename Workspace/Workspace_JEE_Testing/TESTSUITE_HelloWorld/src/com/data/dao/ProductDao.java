/**
 * 
 */
package com.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.data.dao.support.Dao;
import com.data.model.Product;
import com.support.database.querybuilder.SqlQueryBuilder;
import com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
import com.support.database.querybuilder.sql.support.SqlQueryCondition;
import com.support.database.querybuilder.sql.support.flags.SqlQueryBuilderFlags;

/**
 * @author Allianz3076
 *
 */
public class ProductDao extends Dao {

	public ProductDao() throws ClassNotFoundException, SQLException {
		super();
		setTableName("products");
	}
	
	public Product getFirst() throws SQLException {
		String query = new SqlQueryBuilder(getTableName()).select_limited(null, null, 1);
		
		ResultSet rs = getDatabaseManager().createStatment().executeQuery(query);
		
		rs.first();
		
		return new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"), rs.getFloat("price"));
	}

	public int save(Product product) throws SQLException, InvalidQueryBuilderParameter {
		List<String> columns = Arrays.asList("name", "category", "price");
		List<Object> values = Arrays.asList(product.getName(), product.getCategory(), product.getPrice());

		String query = new SqlQueryBuilder(getTableName()).insert(values, columns);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}

	public int delete(Product product) throws SQLException {
		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_EQUAL, product.getId()));
		String query = new SqlQueryBuilder(getTableName()).delete(conditions);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}
}
