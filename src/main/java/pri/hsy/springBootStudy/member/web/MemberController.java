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
import pri.hsy.springBootStudy.member.dto.AuthorityDto;
import pri.hsy.springBootStudy.member.dto.MemberDto;
import pri.hsy.springBootStudy.member.dto.RoleDto;
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
	public ResponseEntity<Void> saveMember(@RequestBody MemberDto member) {
		memberService.saveMember(member);
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
	public List<MemberDto> findAllMember() {
		return memberService.findAllMember();
	}
	
	@RequestMapping("/role/save")
	public ResponseEntity<Void> saveRole(@RequestBody RoleDto role) {
		memberService.saveRole(role);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/role/delete/id/{id}/code/{code}")
	public ResponseEntity<Void> deleteRole(@PathVariable String id,@PathVariable String code) {
		memberService.deleteRole(new RoleDto.RoleId(id, code));
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/role/find/id/{id}/code/{code}")
	@ResponseBody
	public RoleDto findRoleById(@PathVariable String id,@PathVariable String code) {
		return memberService.findRoleById(new RoleDto.RoleId(id, code));
	}
	
	@RequestMapping("/role/find/id/{id}")
	@ResponseBody
	public List<RoleDto> findRoleByRoleId(@PathVariable String id) {
		return memberService.findRoleByRoleId(id);
	}
	
	@RequestMapping("/role/find/code/{code}")
	@ResponseBody
	public List<RoleDto> findRoleByRoleCode(@PathVariable String code) {
		return memberService.findRoleByRoleCode(code);
	}
	
	@RequestMapping("/role/findAll")
	@ResponseBody
	public List<RoleDto> findAllRole() {
		return memberService.findAllRole();
	}
	
	@RequestMapping("/auth/save")
	public ResponseEntity<Void> saveAuthority(@RequestBody AuthorityDto authority) {
		memberService.saveAuthority(authority);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/auth/delete/{id}")
	public ResponseEntity<Void> deleteAuthority(@PathVariable String id) {
		memberService.deleteAuthority(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/auth/find/{id}")
	@ResponseBody
	public AuthorityDto findAuthorityById(@PathVariable String id) {
		return memberService.findAuthorityById(id);
	}
	
	@RequestMapping("/auth/findAll")
	@ResponseBody
	public List<AuthorityDto> findAllAuthority() {
		return memberService.findAllAuthority();
	}
	
}
