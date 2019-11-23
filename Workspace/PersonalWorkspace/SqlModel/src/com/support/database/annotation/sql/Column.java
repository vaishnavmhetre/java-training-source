/**
 * 
 */
package com.support.database.annotation.sql;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
/**
 * @author Allianz3076
 *
 */
public @interface Column {
	public String columnName() default "";
}
