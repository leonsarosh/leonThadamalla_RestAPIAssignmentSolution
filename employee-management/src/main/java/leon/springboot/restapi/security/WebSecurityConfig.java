package leon.springboot.restapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import leon.springboot.restapi.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/addEmployee", "/updateEmployee", "/deleteEmpById", "/addRole",
						"/findAllRoles", "/deleteRoleById", "/updateRoleById", "/updateUser", "/deleteUser")
				.hasAuthority("ADMIN")
				.antMatchers("/",
			            "/swagger-ui.html","/findAllEmployees", "/findEmpById", "/findByFirstName",
						"/findEmpSortedByFirstNameAndDirection", "/findAllUsers", "/addEmpUser")
				.hasAnyAuthority("ADMIN", "USER")
				.antMatchers("/")
					.permitAll()
				.anyRequest()
					.authenticated()
				.and()
				.formLogin()
					.loginProcessingUrl("/login")
					.permitAll()
				.and()
				.logout()
					.logoutSuccessUrl("/login")
					.permitAll()
				.and()
				.cors().and().csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}
}
