/**
 * 
 */
package com.support.database.model.data.builder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.support.database.model.support.caster.support.ValueCaster;
import com.support.database.model.support.caster.support.implicit.ImplicitValueCaster;
import com.support.database.model.support.exception.MetaResolutionException;
import com.support.database.model.support.exception.ModelProcessException;
import com.support.database.model.support.model.util.MetaResolver;

/**
 * @author Allianz3076
 *
 */
public class DataBuilder {

	public static <T> Collection<T> buildAll(ResultSet data, Class<?> modelClass, Field[] fields)
			throws ModelProcessException {
		try {

			List<T> items = new ArrayList<T>();

			if (data.first())
				while (data.next())
					items.add(build(data, modelClass, fields));

			return Collections.unmodifiableList(items);

		} catch (Exception e) {
			throw new ModelProcessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T build(ResultSet data, Class<?> modelClass, Field[] fields) throws ModelProcessException {

		try {
			T modelInstance = (T) modelClass.newInstance();
			for (Field field : fields) {
				String columnName = MetaResolver.getColumnNameForField(field);
				if (com.support.database.model.support.sql.util.MetaResolver.resultSetDataHasColumn(data, columnName)) {
					Method setter = MetaResolver.getSetterForField(modelClass, field);
					if (MetaResolver.hasSetterForField(modelClass, field)) {
						if (com.support.database.model.support.caster.support.MetaResolver
								.isPrimitiveType(field.getType())) {
							setter.invoke(modelInstance, ImplicitValueCaster.class
									.getMethod("convert",
											com.support.database.model.support.caster.support.MetaResolver
													.getPrimitiveImplicitValueCasterForType(field.getType()))
									.invoke(null, com.support.database.model.support.caster.support.MetaResolver
											.getPrimitiveImplicitValueCasterForType(field.getType())
											.cast(ValueCaster.cast(modelClass, data, columnName, field.getType()))));
						} else {
							setter.invoke(modelInstance, field.getType()
									.cast(ValueCaster.cast(modelClass, data, columnName, field.getType())));
						}
					} else {
						if (com.support.database.model.support.caster.support.MetaResolver
								.isPrimitiveType(field.getType())) {
							field.set(modelInstance, ImplicitValueCaster.class
									.getMethod("convert",
											com.support.database.model.support.caster.support.MetaResolver
													.getPrimitiveImplicitValueCasterForType(field.getType()))
									.invoke(null, com.support.database.model.support.caster.support.MetaResolver
											.getPrimitiveImplicitValueCasterForType(field.getType())
											.cast(ValueCaster.cast(modelClass, data, columnName, field.getType()))));
						} else {

							try {
								field.set(modelInstance, field.getType()
										.cast(ValueCaster.cast(modelClass, data, columnName, field.getType())));
							} catch (IllegalAccessException e) {
								field.setAccessible(true);
								field.set(modelInstance, field.getType()
										.cast(ValueCaster.cast(modelClass, data, columnName, field.getType())));
							}
						}
					}
				}
			}
			return modelInstance;
		} catch (MetaResolutionException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new ModelProcessException(e);
		}

	}

}
