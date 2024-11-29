package com.nt.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests(auth -> auth
    		    .requestMatchers("/public/**","/","/home").permitAll()
    		    .requestMatchers("offers").authenticated()
    		    .requestMatchers("/show_balance").hasRole("employee")
    		    .anyRequest().authenticated()
    		   
    		) .formLogin()
    	.and()
    	.logout(); // Enable the default login form

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // this is inmemoryuserdatails no need of database only for testing or  for limited user only
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        var admin = org.springframework.security.core.userdetails.User.withUsername("rahul")
                .password(passwordEncoder.encode("rahul123"))
                .roles("employee")
                .build();

        var user = org.springframework.security.core.userdetails.User.withUsername("vikas")
                .password(passwordEncoder.encode("vikas123"))
                .roles("customer")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
    
}
