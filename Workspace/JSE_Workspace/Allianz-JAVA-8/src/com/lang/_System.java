/**
 * 
 */
package com.lang;

import java.io.Console;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Allianz3076
 *
 */
public class _System {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 10, 20, 30, 40, 50 };

		System.arraycopy(arr1, 0, arr2, 2, 2);
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr2));

		Properties sysProps = System.getProperties();

		Set<Object> keySet = sysProps.keySet();

		for (Object obj : keySet)
			System.out.println(String.format("{ %s = %s }", obj, System.getProperty((String) obj)));

		System.getProperties().list(System.out);

		Properties properties = System.getProperties();
		properties.list(System.out);

		Console console = System.console();

		if (console != null) {
			// Can use console as it is attached

			char[] password = console.readPassword("[%s]", "Password");

			System.out.print("Password: ");
			System.out.println(password);

			console.printf("Welcome &s", "Vaishnav");
			console.flush();
		} else {
			// Cannot use console if run from Eclipse
			System.err.println("ERR: No console attached");
		}

		long currentTimeMillis = System.currentTimeMillis();
		Date date = new Date(currentTimeMillis);
		System.out.println("Current time in millis=" + currentTimeMillis);
		System.out.println(date);

		long nanoTime = System.nanoTime();
		System.out.println("Curent nano time" + nanoTime);
		
		Map<String,String> envMap = System.getenv();
		Set<String> keySetEnv = envMap.keySet();
		
		for(String key: keySetEnv) 
			System.out.println(key+" => "+envMap.get(key));
		
		String pathValue = System.getenv("PATH");
		System.out.println("$PATH="+pathValue);

		SecurityManager securityManager = System.getSecurityManager();
		
		
	}

}
