package org.formation.mediatheque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);
		
		
		http.csrf().disable()
		.authorizeRequests() // ACLS
				.antMatchers("/swagger-ui.html", "/swagger-ui/index.html", "/v3/api-docs/**","/api/**").permitAll() // permession
				//.antMatchers(HttpMethod.GET).permitAll()		
				//.antMatchers(HttpMethod.POST).permitAll()	// pour
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
																							// swager
				.anyRequest().authenticated()
				
				.and()
				//.cors()
				//.and()
				.httpBasic()
				//.formLogin().permitAll()//pour login
				.and()
				.logout().logoutUrl("/logout").invalidateHttpSession(true);//pour logout
		

		

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
	
	
	
	
//	@Override
//	public void configure(WebSecurity http) throws Exception {// pour ignorer
//		// TODO Auto-generated method stub
//		// super.configure(web);
//
//		.antMatchers("/**/*.js", "/**/*.css", "/**/*.png");
//	}

	
	
//	@EnableWebSecurity
//	@Configuration
//	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.cors();
//	    }

	    @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        UrlBasedCorsConfigurationSource source = new
	                UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	        return source;
	    }
	//}



	
	
}
