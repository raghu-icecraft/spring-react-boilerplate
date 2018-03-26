package com.naughtyzombie.boilerplate.springreactboilerplate.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JWTLogoutSuccessHandler implements LogoutSuccessHandler {

	/**
	 * On a successful AJAX logout, send a redirect to /api/account. The response body
	 * won't contain anything particularly useful, but the response headers will contain
	 * the latest session and security (CSRF) tokens, meaning that subsequent POST requests
	 * can work.
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		log.info("Logout Request");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().flush();
	}
}
