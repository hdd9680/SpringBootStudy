package pri.hsy.springBootStudy.member.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pri.hsy.springBootStudy.member.dto.MemberDto;
import pri.hsy.springBootStudy.member.service.MemberService;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;
	
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
	
	@RequestMapping("/save")
	public ResponseEntity<Void> registMember(@RequestBody MemberDto member) {
		memberService.registerMember(member);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMember(@PathVariable String id) {
		memberService.deleteMember(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/find/{id}")
	@ResponseBody
	public MemberDto findMemberById(@PathVariable String id) {
		return memberService.findMemberById(id);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<MemberDto>findAllMember() {
		return memberService.findAllMember();
	}
	
}
