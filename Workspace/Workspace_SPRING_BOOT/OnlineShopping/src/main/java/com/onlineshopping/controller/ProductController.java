/**
 * 
 */
package com.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @author Allianz3076
 *
 */
public class ProductController {

	@RequestMapping({ "/helloWorld" })
	public String helloWorld() {
		return "Hello";
	}
}
