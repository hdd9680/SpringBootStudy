package pri.hsy.springBootStudy.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class SecurityController {
	
	@GetMapping("/")
	public String root() {
		return "home";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin/pay")
	public String adminPay() {
		return "adminPay";
	}
	
	@GetMapping("/admin/**")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
