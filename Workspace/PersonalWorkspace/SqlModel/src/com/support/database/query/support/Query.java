/**
 * 
 */
package com.support.database.query.support;

/**
 * @author Allianz3076
 *
 */
public class Query {

	protected String query;

	public Query() {
	}

	public Query(String query) {
		setQuery(query);
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getQuery());
		builder.replace(builder.length()-1, builder.length(), "");
		return '(' + builder.toString() + ')';
	}

}
