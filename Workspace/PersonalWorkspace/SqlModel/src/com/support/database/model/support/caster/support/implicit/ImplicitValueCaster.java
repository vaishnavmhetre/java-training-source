/**
 * 
 */
package com.support.database.model.support.caster.support.implicit;

import java.util.HashMap;
import java.util.Map;

import com.support.database.model.support.caster.support.contract.supportabstract.Caster;
import com.support.database.model.support.caster.support.implicit.casts.FloatCaster;
import com.support.database.model.support.caster.support.implicit.casts.IntegerCaster;
import com.support.database.model.support.caster.support.implicit.casts.LongCaster;
import com.support.database.model.support.caster.support.implicit.casts.StringCaster;

/**
 * @author Allianz3076
 *
 */
public class ImplicitValueCaster {

	public static Map<Class<?>, Class<? extends Caster<?>>> casts = new HashMap<Class<?>, Class<? extends Caster<?>>>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(String.class, StringCaster.class);
			put(Integer.class, IntegerCaster.class);
			put(Float.class, FloatCaster.class);
			put(Long.class, LongCaster.class);
		}

	};

	public static Map<Class<?>, Class<?>> primitiveCasts = new HashMap<Class<?>, Class<?>>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(int.class, Integer.class);
			put(float.class, Float.class);
			put(long.class, Long.class);
		}

	};

	public static int convert(Integer data) {
		return data.intValue();
	}

	public static float convert(Float data) {
		return data.floatValue();
	}

	public static long convert(Long data) {
		return data.longValue();
	}

	/*
	 * Dummy passer to cover other types
	 */
	public static <T> T convert(T data) {
		return data;
	}
}
