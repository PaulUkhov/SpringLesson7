package org.example.spring7homework2.config;

import lombok.RequiredArgsConstructor;
import org.example.spring7homework2.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final UserRepository userRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/resource/admin/issue/private-data/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/resource/user/reader/**").hasAnyAuthority("ROLE_READER")
                        .requestMatchers("/api/resource/auth/public-data/book/**").authenticated()
                        .requestMatchers("/api/resource/**").permitAll()
                        .anyRequest().denyAll())
//                .formLogin(formLogin -> formLogin.loginPage("/login"))
                .formLogin(formLogin ->
                        formLogin.defaultSuccessUrl("/api/resource/auth/public-data/book",true))
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }
}
