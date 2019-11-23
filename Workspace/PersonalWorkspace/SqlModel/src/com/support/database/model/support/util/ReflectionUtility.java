/**
 * 
 */
package com.support.database.model.support.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Allianz3076
 *
 */
public class ReflectionUtility {

	/**
	 * Create new instance of specified class and type
	 *
	 * @param clazz of instance
	 * @param       <T> type of object
	 * @return new Class instance
	 */
	public static <T> T getInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

	/**
	 * Retrieving fields list of specified class If recursively is true, retrieving
	 * fields from all class hierarchy
	 *
	 * @param clazz       where fields are searching
	 * @param recursively param
	 * @return list of fields
	 */
	public static Field[] getDeclaredFields(Class<?> clazz, boolean recursively) {
		List<Field> fields = new LinkedList<Field>();
		Field[] declaredFields = clazz.getDeclaredFields();
		Collections.addAll(fields, declaredFields);

		Class<?> superClass = clazz.getSuperclass();

		if (superClass != null && recursively) {
			Field[] declaredFieldsOfSuper = getDeclaredFields(superClass, recursively);
			if (declaredFieldsOfSuper.length > 0)
				Collections.addAll(fields, declaredFieldsOfSuper);
		}

		return fields.toArray(new Field[fields.size()]);
	}

	/**
	 * Retrieving fields list of specified class and which are annotated by incoming
	 * annotation class If recursively is true, retrieving fields from all class
	 * hierarchy
	 *
	 * @param clazz           - where fields are searching
	 * @param annotationClass - specified annotation class
	 * @param recursively     param
	 * @return list of annotated fields
	 */
	public static Field[] getAnnotatedDeclaredFields(Class<?> clazz, Class<? extends Annotation> annotationClass,
			boolean recursively) {
		Field[] allFields = getDeclaredFields(clazz, recursively);
		List<Field> annotatedFields = new LinkedList<Field>();

		for (Field field : allFields) {
			if (field.isAnnotationPresent(annotationClass))
				annotatedFields.add(field);
		}

		return annotatedFields.toArray(new Field[annotatedFields.size()]);
	}
	
	/**
	 * Retrieving methods list of specified class If recursively is true, retrieving
	 * methods from all class hierarchy
	 *
	 * @param clazz       where methods are searching
	 * @param recursively param
	 * @return list of fields
	 */
	public static Method[] getDeclaredMethods(Class<?> clazz, boolean recursively) {
		List<Method> methods = new LinkedList<Method>();
		Method[] declaredFields = clazz.getDeclaredMethods();
		Collections.addAll(methods, declaredFields);

		Class<?> superClass = clazz.getSuperclass();

		if (superClass != null && recursively) {
			Method[] declaredFieldsOfSuper = getDeclaredMethods(superClass, recursively);
			if (declaredFieldsOfSuper.length > 0)
				Collections.addAll(methods, declaredFieldsOfSuper);
		}

		return methods.toArray(new Method[methods.size()]);
	}

	/**
	 * Retrieving methods list of specified class and which are annotated by incoming
	 * annotation class If recursively is true, retrieving methods from all class
	 * hierarchy
	 *
	 * @param clazz           - where methods are searching
	 * @param annotationClass - specified annotation class
	 * @param recursively     param
	 * @return list of annotated fields
	 */
	public static Method[] getAnnotatedDeclaredMethods(Class<?> clazz, Class<? extends Annotation> annotationClass,
			boolean recursively) {
		Method[] allMethods = getDeclaredMethods(clazz, recursively);
		List<Method> annotatedMethods = new LinkedList<Method>();

		for (Method field : allMethods) {
			if (field.isAnnotationPresent(annotationClass))
				annotatedMethods.add(field);
		}

		return annotatedMethods.toArray(new Method[annotatedMethods.size()]);
	}
}
