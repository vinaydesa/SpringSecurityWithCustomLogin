package SpringSecurityAppBasedLogin.securityHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String appName = request.getParameter("appName");
		String targetUrl = determineTargetUrl(authentication, appName);

		if (targetUrl.isEmpty()) {
			SecurityContextHolder.getContext().setAuthentication(null);
			response.sendRedirect("/login?unauth=true");
		} else
			response.sendRedirect(targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication, String appName) {
		String url = "";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}
		int index = roles.indexOf(new Object() {
			@Override
			public boolean equals(Object obj) {
				return obj.toString().contains(appName);
			}
		});

		String roleName = null;
		if (index != -1) {
			roleName = roles.get(index);
			roles.get(index);
			if (roleName.contains("APP1"))
				url = "/app1";
			else if (roleName.contains("APP2"))
				url = "/app2";
		}

		return url;
	}

}
