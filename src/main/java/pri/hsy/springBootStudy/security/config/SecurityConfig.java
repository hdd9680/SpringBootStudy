package pri.hsy.springBootStudy.security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	
	@Value("${spring.security.strategy}")
	private String securityContextHolderStrategy;
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
        	web.ignoring().requestMatchers("/js/**");
        };
    }
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		// 접근 URL 설정
		http.authorizeHttpRequests()
				.requestMatchers("/login", "/logout", "/join").permitAll()
				.anyRequest().authenticated();
		
		// 인증 설정
		http.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.failureUrl("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.loginProcessingUrl("/login")
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						log.info("authentication : {}", authentication.getName());
						
						RequestCache requestCache = new HttpSessionRequestCache();
						SavedRequest savedRequest = requestCache.getRequest(request, response);
						
						response.sendRedirect(savedRequest.getRedirectUrl());
					}
				})
				.failureHandler(new AuthenticationFailureHandler() {
					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
							AuthenticationException exception) throws IOException, ServletException {
						log.info("exception : {}", exception.getMessage());
						response.sendRedirect("login");
					}
				})
				.permitAll();
		
		// 인증 해제(로그아웃)
		http.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.deleteCookies("remember-me")
				.addLogoutHandler(new LogoutHandler() {
					
					@Override
					public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
						HttpSession session = request.getSession();
						session.invalidate();
					}
				})
				.logoutSuccessHandler(new LogoutSuccessHandler() {
					
					@Override
					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
							throws IOException, ServletException {
						response.sendRedirect("/login");
					}
				});
		
		// remember-me 설정
		http.rememberMe()
				.tokenValiditySeconds(60 * 60 * 4);
		
		// 동시 세션 제어(중복 로그인 제어)
		http.sessionManagement()
				.maximumSessions(1)
					.maxSessionsPreventsLogin(false);
		// 세션 고정 보호(로그인 시 JSESSIONID 변경)
		http.sessionManagement()
				.sessionFixation()
					.changeSessionId();
		// 세선 정책 설정
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		
		// 인증/인가 예외 처리
//		http.exceptionHandling()
//				.authenticationEntryPoint(new AuthenticationEntryPoint() {
//					
//					@Override
//					public void commence(HttpServletRequest request, HttpServletResponse response,
//							AuthenticationException authException) throws IOException, ServletException {
//						
//						log.info("이게 왜 나오는지 모르겠음");
//						
//						response.setStatus(401);
//						response.setContentType("application/json;charset=UTF-8");
//						response.getWriter().append("인증이 필요한 서비스입니다.");
//					}
//				})
//				.accessDeniedHandler(new AccessDeniedHandler() {
//					
//					@Override
//					public void handle(HttpServletRequest request, HttpServletResponse response,
//							AccessDeniedException accessDeniedException) throws IOException, ServletException {
//						response.setStatus(403);
//						response.setContentType("application/json;charset=UTF-8");
//						response.getWriter().append("현재 권한으로는 접근할 수 없는 서비스입니다.");
//					}
//				});
		
		SecurityContextHolder.setStrategyName(securityContextHolderStrategy);
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
