/**
 * 
 */
package com.support.database.model.support.model.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.support.database.GeneralUtil;
import com.support.database.annotation.mutator.Setter;
import com.support.database.annotation.sql.Column;
import com.support.database.annotation.sql.Id;
import com.support.database.annotation.sql.Table;
import com.support.database.model.support.caster.support.contract.supportabstract.Caster;
import com.support.database.model.support.exception.MetaResolutionException;
import com.support.database.model.support.util.ReflectionUtility;
import com.support.database.translator.NameTranslator;

/**
 * @author Allianz3076
 *
 */
public class MetaResolver {
	public static Map<String, Class<?>> getColumnsMap(Field[] fields) {
		Map<String, Class<?>> columns = new HashMap<String, Class<?>>();
		for (Field field : fields)
			columns.put(getColumnNameForField(field), field.getType());

		return Collections.unmodifiableMap(columns);
	}

	public static String getSpecifiedTableNameForClass(Class<?> modelClass) {
		String tableName = modelClass.getAnnotation(Table.class).tableName();
		return tableName != null ? tableName.trim() : null;
	}

	public static String getTableNameForClass(Class<?> modelClass) {
		if (hasSpecifiedTableNameForClass(modelClass))
			return getSpecifiedTableNameForClass(modelClass);
		else {
			return NameTranslator.translateUpperCamelToPluralUnderscores(modelClass.getSimpleName());
		}
	}

	public static boolean hasSpecifiedTableNameForClass(Class<?> modelClass) {
		String tableName = getSpecifiedTableNameForClass(modelClass);
		return (tableName != null && tableName.trim().length() > 0);
	}

	@SuppressWarnings("unchecked")
	public static Map<Class<?>, Class<? extends Caster<?>>> getExplicitCasts(Class<?> modelClass)
			throws MetaResolutionException {

		try {
			return (Map<Class<?>, Class<? extends Caster<?>>>) modelClass.getField("casts")
					.get(ReflectionUtility.getInstance(modelClass));
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | InstantiationException e) {
			throw new MetaResolutionException(e);
		} catch (NoSuchFieldException e) {
		}

		return null;
	}

	public static boolean hasExplicitCasts(Class<?> modelClass) throws MetaResolutionException {

		return getExplicitCasts(modelClass) != null;
	}

	public static Class<? extends Caster<?>> getExplicitCasterForType(Class<?> modelClass, Class<?> typeClass)
			throws MetaResolutionException {

		return (hasExplicitCasts(modelClass)) ? getExplicitCasts(modelClass).get(typeClass) : null;
	}

	public static boolean hasExplicitCasterForType(Class<?> modelClass, Class<?> typeClass)
			throws MetaResolutionException {
		return (hasExplicitCasts(modelClass) == false) ? false
				: (getExplicitCasterForType(modelClass, typeClass) != null);
	}

	public static String getSpecifiedColumnNameForField(Field field) {
		String columnName = field.getAnnotation(Column.class).columnName();
		return columnName != null ? columnName.trim() : null;
	}

	public static String getColumnNameForField(Field field) {
		if (hasSpecifiedColumnNameForField(field))
			return getSpecifiedColumnNameForField(field);
		else
			return NameTranslator.translateLowerCamelToUnderscores(field.getName());
	}

	public static boolean hasSpecifiedColumnNameForField(Field field) {
		String columnName = getSpecifiedColumnNameForField(field);
		return (columnName != null && columnName.trim().length() > 0);
	}

	public static Method getSetterForField(Class<?> modelClass, Field field) throws MetaResolutionException {
		if (hasSpecifiedSetterForField(modelClass, field))
			return getSpecifiedSetterForField(modelClass, field);
		else if (hasDerivedSetterForField(modelClass, field))
			return deriveSetterForField(modelClass, field);
		else
			return null;
	}

	public static boolean hasSetterForField(Class<?> modelClass, Field field) throws MetaResolutionException {
		return (getSetterForField(modelClass, field) != null);
	}

	public static boolean hasSpecifiedSetterForField(Class<?> modelClass, Field field) {
		return (getSpecifiedSetterForField(modelClass, field) != null);
	}

	public static Method getSpecifiedSetterForField(Class<?> modelClass, Field field) {
		Method[] methods = ReflectionUtility.getAnnotatedDeclaredMethods(modelClass, Setter.class, false);

		for (Method method : methods)
			if (method.getAnnotation(Setter.class).fieldName().equals(field.getName()))
				return method;

		return null;
	}

	public static Method deriveSetterForField(Class<?> modelClass, Field field) throws MetaResolutionException {
		String fieldName = field.getName();
		try {
			return modelClass.getDeclaredMethod("set" + NameTranslator.translateLowerCamelToUpperCamel(fieldName),
					field.getType());
		} catch (NoSuchMethodException | SecurityException e) {
			throw new MetaResolutionException(e);
		}
	}

	public static boolean hasDerivedSetterForField(Class<?> modelClass, Field field) throws MetaResolutionException {
		try {
			modelClass.getDeclaredMethod("set" + NameTranslator.translateLowerCamelToUpperCamel(field.getName()),
					field.getType());
			return true;
		} catch (NoSuchMethodException e) {
			return false;
		} catch (SecurityException e) {
			throw new MetaResolutionException(e);
		}
	}

	public static Field getIdFieldForModel(Class<?> modelClass) throws MetaResolutionException {
		Field[] idFields = ReflectionUtility.getAnnotatedDeclaredFields(modelClass, Id.class, false);

		if (idFields.length > 1)
			throw new MetaResolutionException("Any Model (here -> " + modelClass + ") must have only one Id field, but "
					+ GeneralUtil.appendArrayToBuilderWithParantheses(new StringBuilder(idFields + " -> "),
							Arrays.asList(idFields)).toString()
					+ " fields are defined as Id");
		else if (idFields.length == 1)
			return idFields[0];
		else
			return deriveIdFieldForModel(modelClass);
	}

	public static Field deriveIdFieldForModel(Class<?> modelClass) {
		Field[] idFields = ReflectionUtility.getDeclaredFields(modelClass, false);

		for (Field field : idFields)
			if (field.getName().equalsIgnoreCase("id")
					|| field.getName().equalsIgnoreCase(modelClass.getSimpleName() + "id"))
				return field;

		return null;
	}

	public static boolean hasIdFieldForModel(Class<?> modelClass) {
		try {
			return getIdFieldForModel(modelClass) != null;
		} catch (MetaResolutionException e) {
			return false;
		}
	}

	public static Field forceGetIdFieldForModel(Class<?> modelClass) throws MetaResolutionException {
		if (hasIdFieldForModel(modelClass))
			return getIdFieldForModel(modelClass);

		throw new MetaResolutionException(
				"No compatible Id field found, neither could derive for model -> " + modelClass);
	}
}
