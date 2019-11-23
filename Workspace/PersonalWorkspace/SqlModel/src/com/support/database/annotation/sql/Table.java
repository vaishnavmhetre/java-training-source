/**
 * 
 */
package com.support.database.annotation.sql;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Documented
@Retention(RUNTIME)
/**
 * @author Allianz3076
 *
 */
public @interface Table {
	public String tableName() default "";
}
