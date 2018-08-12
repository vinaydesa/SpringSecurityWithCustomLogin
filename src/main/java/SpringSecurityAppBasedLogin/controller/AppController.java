package SpringSecurityAppBasedLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping({"/login","/"})
	public String login() {
		return "Login";
	}
	
	@GetMapping("/app1")
	public String displayApp1() {
		return "app1";
	}
	
	@GetMapping("/app2")
	public String displayApp2() {
		return "app2";
	}

}
