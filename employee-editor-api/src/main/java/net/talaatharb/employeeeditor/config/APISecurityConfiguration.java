/**
 * 
 */
package net.talaatharb.employeeeditor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author mharb
 *
 */
@Configuration
@EnableWebSecurity
public class APISecurityConfiguration extends WebSecurityConfigurerAdapter {
	/**
	 * 
	 */
	private static final String API_PATH = "/api/**";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http // HTTP Security
				.cors().and() // CORS policy
				.csrf().disable() // CSRF disable
				.authorizeRequests() // Configuration for authorization of requests
				.antMatchers(HttpMethod.OPTIONS, API_PATH).permitAll() // API end points
				.antMatchers(HttpMethod.DELETE, API_PATH).authenticated() // API end points
				.antMatchers(HttpMethod.GET, API_PATH).authenticated() // API end points
				.antMatchers(HttpMethod.POST, API_PATH).authenticated() // API end points
				.antMatchers(HttpMethod.PUT, API_PATH).authenticated() // API end points
				.and().formLogin().permitAll().successHandler((request, response, authentication) -> {
					// Nothing
				});
	}

	/**
	 * CORS filter configuration bean
	 * 
	 * @return The CORS bean
	 */
	@Bean
	public CORSFilter corsFilter() {
		CorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.OPTIONS);
		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.PUT);
		((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**", config);
		return new CORSFilter(source);
	}

}
