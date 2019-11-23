/**
 * 
 */
package com.support.database.translator;

import java.util.Arrays;
import java.util.List;

import org.atteo.evo.inflector.English;

import com.google.common.base.CaseFormat;

/**
 * @author Allianz3076
 *
 */
public class NameTranslator {
	public static String translateUnderscoresToLowerCamel(String input) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, input);
	}

	public static String translateLowerCamelToUnderscores(String input) {
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, input);
	}

	public static String translateUnderscoresToUpperCamel(String input) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, input);
	}

	public static String translateUpperCamelToUnderscores(String input) {
		return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, input);
	}

	public static String translateLowerCamelToUpperCamel(String input) {
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, input);
	}

	public static String translateUpperCamelToLowerCamel(String input) {
		return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, input);
	}

	public static String translateUpperCamelToPluralUnderscores(String input) {
		String underscoredString = translateUpperCamelToUnderscores(input);
		String[] underscoredSplits = underscoredString.split("_");

		String resultantString = English.plural(underscoredSplits[0]);

		if (underscoredSplits.length > 1) {
			List<String> toIgnoreTheFirstItemList = Arrays.asList(underscoredSplits);
			toIgnoreTheFirstItemList.remove(0);

			underscoredSplits = (String[]) toIgnoreTheFirstItemList.toArray();

			for (String string : underscoredSplits)
				resultantString = String.join("_", resultantString, English.plural(string));

			return resultantString;
		}

		return resultantString;
	}
}
