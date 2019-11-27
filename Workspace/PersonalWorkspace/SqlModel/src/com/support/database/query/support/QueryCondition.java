/**
 * 
 */
package com.support.database.query.support;

import com.support.database.query.builder.util.QueryBuilderUtil;
import com.support.database.query.support.contract.QueryConditionContract;

/**
 * @author Allianz3076
 *
 */
public class QueryCondition implements QueryConditionContract {
	protected String columnName;
	protected String operator;
	protected Object value;

	protected boolean conditionIsJoiner;
	protected String joiner;

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	protected void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	protected void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	protected void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the conditionIsJoiner
	 */
	public boolean isConditionJoiner() {
		return conditionIsJoiner;
	}

	/**
	 * @param conditionIsJoiner the conditionIsJoiner to set
	 */
	protected void setConditionIsJoiner(boolean conditionIsJoiner) {
		this.conditionIsJoiner = conditionIsJoiner;
	}

	/**
	 * @return the joiner
	 */
	public String getJoiner() {
		return joiner;
	}

	/**
	 * @param joiner the joiner to set
	 */
	protected void setJoiner(String joiner) {
		this.joiner = joiner;
	}

	/**
	 * @param columnName
	 * @param operator
	 * @param value
	 */
	public QueryCondition(String columnName, String operator, Object value) {
		setColumnName(columnName);
		setOperator(operator);
		setValue(value);
		setConditionIsJoiner(false);
	}

	public QueryCondition(String joiner) {
		setJoiner(joiner);
		setConditionIsJoiner(true);
	}

	@Override
	public String getSqlString() {
		if (isConditionJoiner())
			return getJoiner();
		else
			return new StringBuilder(QueryBuilderUtil.getBracedName(columnName) + operator
					+ QueryBuilderUtil.getQueryAppendableValue(getValue())).toString();

	}
}
