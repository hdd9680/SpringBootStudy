package pri.hsy.springBootStudy.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/page/join")
	public String movePageLogin(@RequestParam(required = false, defaultValue = "0") int value) {
		
		if(value == 0) {
			log.debug("debug log");
		} else if(value == 1) {
			log.info("info log");
		} else if(value == 2) {
			log.error("error log");
		}
		
		return "member/join";
	}
	
}
