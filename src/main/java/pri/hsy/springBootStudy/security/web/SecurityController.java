package pri.hsy.springBootStudy.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pri.hsy.springBootStudy.security.service.SecurityService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SecurityController {
	
	private final SecurityService securityService;
	
	@GetMapping("/")
	public String root() {
		return "/index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "/security/login";
	}
	
	@GetMapping("/join")
	public String joinPage() {
		return "/security/join";
	}
	
}
