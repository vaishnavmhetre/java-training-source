package com.support.database.model.support.model.contract;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public interface ModelSupport<T> {

	Field[] getColumnFields();

	Set<String> getColumns();

	Map<String, Class<?>> getColumnsWithType();

}