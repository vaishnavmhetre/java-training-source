/**
 * 
 */
package com.support.database.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import com.support.database.annotation.Column;
import com.support.database.model.support.util.ReflectionUtility;

/**
 * @author Allianz3076
 *
 */
public class Model<T> {

	private Class<T> modelClazz;

	/**
	 * @return the type
	 */
	public Class<T> getType() {
		return this.modelClazz;
	}

	public Model(Class<T> clazz) {
		this.modelClazz = clazz;
	}

	public List<T> all(List<String> columns) {

		Field[] fields = ReflectionUtility.getAnnotatedDeclaredFields(modelClazz, Column.class, false);

		System.out.println(Arrays.asList(fields));
		return null;
	}
}
