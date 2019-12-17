/**
 * 
 */
package net.talaatharb.employeeeditor.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mharb
 *
 */
@Controller
public class HomeController {

	/**
	 * Mapping for the /home end point
	 * 
	 * @return The contents of the page index.html
	 */
	@GetMapping(path = { "/index", "/site/**" })
	public String home() {
		return "forward:/index.html";
	}

	/**
	 * Mapping for the /login end point
	 * 
	 * @return The contents of the page index.html
	 */
	@GetMapping(path = "/login", produces = MediaType.TEXT_HTML_VALUE)
	public String login() {
		return "forward:/index.html";
	}

}
