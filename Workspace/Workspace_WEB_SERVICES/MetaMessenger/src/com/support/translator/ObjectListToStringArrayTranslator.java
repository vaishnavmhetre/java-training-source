/**
 * 
 */
package com.support.translator;

import java.util.List;

/**
 * @author Allianz3076
 *
 */
public class ObjectListToStringArrayTranslator {
	public static String[] translate(List<?> list) {
		
		String[] array = new String[list.size()];
		int index = 0;
		for (Object value : list) 
		  array[index++] = value.toString();
		
		return array;
	}
}
