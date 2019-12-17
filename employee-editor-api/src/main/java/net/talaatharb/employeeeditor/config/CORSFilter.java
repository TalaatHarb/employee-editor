/**
 * 
 */
package net.talaatharb.employeeeditor.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author mharb
 *
 */
@Configuration
public class CORSFilter extends CorsFilter {

	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	
	private CorsConfigurationSource source;

	/**
	 * Constructor
	 * 
	 * @param source
	 */
	public CORSFilter(CorsConfigurationSource source) {
		super((CorsConfigurationSource) source);
		this.source = source;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		

		if (response.getHeader("Access-Control-Allow-Headers") == null) {
			response.addHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Access-Control-Allow-Methods, Access-Control-Allow-Credentials, Access-Control-Max-Age");
		}
		if (response.getHeader(ACCESS_CONTROL_ALLOW_ORIGIN) == null) {
			final List<String> origins = source.getCorsConfiguration(request).getAllowedOrigins();
			for (final String origin : origins) {
				response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
			}
			final String requestOrigin = request.getHeader("Origin");
			if(!origins.contains(requestOrigin)) {
				// Echo origin
				response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, requestOrigin);
			}
		}
		if (response.getHeader("Access-Control-Allow-Credentials") == null) {
			response.addHeader("Access-Control-Allow-Credentials", "true");
		}
		if (response.getHeader("Access-Control-Allow-Methods") == null) {
			final StringBuilder builder = new StringBuilder();
			final List<String> methods = source.getCorsConfiguration(request).getAllowedMethods();
			for (int i = 0; i < (methods.size() - 1); i++) {
				builder.append(methods.get(i));
				builder.append(", ");
			}
			builder.append(methods.get(methods.size() - 1));
			response.addHeader("Access-Control-Allow-Methods", builder.toString());
		}
		if(response.getHeader("Access-Control-Max-Age") == null) {
			response.addHeader("Access-Control-Max-Age", "86400");
		}

		filterChain.doFilter(request, response);
	}

}
