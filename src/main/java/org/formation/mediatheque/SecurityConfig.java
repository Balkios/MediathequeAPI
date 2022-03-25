package org.formation.mediatheque;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);
		http.csrf().disable()
		.authorizeRequests() // ACLS
				.antMatchers("/swagger-ui.html", "/swagger-ui/index.html", "/v3/api-docs/**").permitAll() // permession
																											// pour
																											// swager
				.antMatchers(HttpMethod.GET).authenticated() // nécessite une authentification pour les méthodes GET de
																// l’api
				.antMatchers("/api/**").hasRole("ADMIN").and().formLogin().permitAll()//pour login
				.and().logout().logoutUrl("/logout").invalidateHttpSession(true);//pour logout
		

	}

	@Override
	public void configure(WebSecurity web) throws Exception {// pour ignorer
		// TODO Auto-generated method stub
		// super.configure(web);

		web.ignoring().antMatchers("/**/*.js", "/**/*.css", "/**/*.png");
	}
}
