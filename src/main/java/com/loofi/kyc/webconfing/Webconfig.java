package com.loofi.kyc.webconfing;


import com.loofi.kyc.authentication.AuthEntryPointJwt;
import com.loofi.kyc.authentication.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
@EnableWebMvc
public class Webconfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(HttpMethod.POST,"/api/customerkyc").hasAnyRole("CHECKER")
				.antMatchers(HttpMethod.GET, "/api/customerkyc/**").hasAnyRole("CHECKER", "MAKER")
				.antMatchers(HttpMethod.POST,"/api/customerkyc/multiple").hasAnyRole("MAKER")
				.anyRequest().authenticated();
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public TokenFilter authenticationJwtTokenFilter() {
		return new TokenFilter();
	}
}
