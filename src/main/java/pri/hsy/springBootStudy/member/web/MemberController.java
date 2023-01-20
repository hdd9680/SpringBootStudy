package pri.hsy.springBootStudy.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/page/join")
	public String movePageLogin() {
		return "member/join";
	}
	
}
