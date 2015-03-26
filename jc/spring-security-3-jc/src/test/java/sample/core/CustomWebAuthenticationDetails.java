package sample.core;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

@SuppressWarnings("serial")
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
	private String customProperty;

	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		this.customProperty = request.getHeader("custom");
	}

	public String getCustomProperty() {
		return customProperty;
	}
}