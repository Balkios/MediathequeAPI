package org.formation.mediatheque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);
		http.csrf().disable()
		.authorizeRequests() // ACLS
				.antMatchers("/swagger-ui.html", "/swagger-ui/index.html", "/v3/api-docs/**").permitAll() // permession
																											// pour
																											// swager
				.anyRequest().authenticated()
				.and()
				.formLogin().permitAll()//pour login
				.and().logout().logoutUrl("/logout").invalidateHttpSession(true);//pour logout
		

	}

	@Override
	public void configure(WebSecurity web) throws Exception {// pour ignorer
		// TODO Auto-generated method stub
		// super.configure(web);

		web.ignoring().antMatchers("/**/*.js", "/**/*.css", "/**/*.png");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		// TODO Auto-generated method stub
//		return super.authenticationManagerBean();
//	}
	
	
}
