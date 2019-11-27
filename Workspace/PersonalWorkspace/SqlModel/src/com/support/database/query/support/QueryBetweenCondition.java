/**
 * 
 */
package com.support.database.query.support;

import com.support.database.query.builder.util.QueryBuilderUtil;
import com.support.database.query.builder.util.flags.QueryBuilderFlags;
import com.support.database.query.support.contract.QueryConditionContract;

/**
 * @author Allianz3076
 *
 */
public class QueryBetweenCondition implements QueryConditionContract {

	public String columnName;
	public Object min;
	public Object max;

	public QueryBetweenCondition(String columnName, Object min, Object max) {
		super();
		this.columnName = columnName;
		this.min = min;
		this.max = max;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.support.database.query.support.contract.QueryConditionContract#
	 * getSqlString()
	 */
	@Override
	public String getSqlString() {
		return new StringBuilder(QueryBuilderUtil.getBracedName(columnName) + QueryBuilderFlags.CONDITION_BETWEEN
				+ QueryBuilderUtil.getQueryAppendableValue(min) + QueryBuilderFlags.CONDITION_JOINER_AND
				+ QueryBuilderUtil.getQueryAppendableValue(max)).toString();
	}

}
