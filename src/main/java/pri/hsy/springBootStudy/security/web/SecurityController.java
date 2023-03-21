package pri.hsy.springBootStudy.security.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pri.hsy.springBootStudy.security.service.SecurityService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SecurityController {
	
	private final SecurityService securityService;
	
	@GetMapping("/")
	public String root() {
		
		log.info("super Thread result : {}", SecurityContextHolder.getContext().getAuthentication().getName());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				log.info("sub Thread result : {}", SecurityContextHolder.getContext().getAuthentication().getName());
			}
		}).start();
		
		log.info("test {}", securityService.findUser("hdd9680"));
		
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
	
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
	
}
