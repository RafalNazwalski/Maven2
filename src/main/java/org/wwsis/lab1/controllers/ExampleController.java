
package org.wwsis.lab1.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
	
	@RequestMapping("/")
	public String home(HttpSession session) {
		session.setAttribute("s1", "Witaj dobry człowieku! :)");
		return "startPage";
	}

}
