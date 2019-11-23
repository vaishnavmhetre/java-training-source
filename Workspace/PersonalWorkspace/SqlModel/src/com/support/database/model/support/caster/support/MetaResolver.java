/**
 * 
 */
package com.support.database.model.support.caster.support;

import com.support.database.model.support.caster.support.implicit.ImplicitValueCaster;
import com.support.database.model.support.exception.MetaResolutionException;
import com.support.database.model.support.exception.ModelProcessException;

/**
 * @author Allianz3076
 *
 */
public class MetaResolver {

	public static Class<?> getImplicitValueCasterForType(Class<?> typeClass) {
		return ImplicitValueCaster.casts.get(typeClass);
	}

	public static boolean hasImplicitValueCasterForType(Class<?> typeClass) {
		return getImplicitValueCasterForType(typeClass) != null;
	}

	public static Class<?> getPrimitiveImplicitValueCasterForType(Class<?> typeClass) {
		return ImplicitValueCaster.primitiveCasts.get(typeClass);
	}

	public static boolean hasPrimitiveImplicitValueCasterForType(Class<?> typeClass) {
		return getPrimitiveImplicitValueCasterForType(typeClass) != null;
	}

	public static boolean isPrimitiveType(Class<?> typeClass) {
		return ImplicitValueCaster.primitiveCasts.containsKey(typeClass);
	}

	public static Class<?> getCasterForType(Class<?> modelClass, Class<?> typeClass) throws ModelProcessException {
		try {
			if (com.support.database.model.support.model.util.MetaResolver.hasExplicitCasterForType(modelClass,
					typeClass)) {
				return com.support.database.model.support.model.util.MetaResolver.getExplicitCasterForType(modelClass,
						typeClass);
			} else if (isPrimitiveType(typeClass)) {
				if (hasImplicitValueCasterForType(getPrimitiveImplicitValueCasterForType(typeClass))) {
					return getImplicitValueCasterForType(getPrimitiveImplicitValueCasterForType(typeClass));
				} else {
					throw new ModelProcessException("No Caster defined for primitive type \"" + typeClass
							+ "\" in model \"" + modelClass + "\"");
				}
			} else if (hasImplicitValueCasterForType(typeClass)) {
				return getImplicitValueCasterForType(typeClass);
			} else {
				throw new ModelProcessException(
						"No Caster defined for type \"" + typeClass + "\" in model \"" + modelClass + "\"");
			}
		} catch (MetaResolutionException e) {
			throw new ModelProcessException(e);
		}
	}

}
