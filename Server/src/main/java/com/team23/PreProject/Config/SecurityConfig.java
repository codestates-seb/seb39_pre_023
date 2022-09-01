package com.team23.PreProject.Config;

import com.team23.PreProject.filter.FirstFilter;
import com.team23.PreProject.filter.JwtAuthenticationFilter;
import com.team23.PreProject.filter.JwtAuthorizationFilter;
import com.team23.PreProject.member.repository.member_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

//@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    member_repository member_repository;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //필터 설정 - 단순 헤더 분석해서 인증 처리
        //http.addFilterBefore(new FirstFilter(), BasicAuthenticationFilter.class);


        http.csrf().disable();
//        http.csrf() // 추가
//                .ignoringAntMatchers("/h2-console/**").disable();//포스트맨 사용 가능, h2 막히면 안되니까 별도로 처리
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .cors().configurationSource(corsConfigurationSource()).and() //cors.disable 안먹힘
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated().and()
                .apply(new CustomDsl()) // 추가
                .and()
                .authorizeRequests()
                .antMatchers("/DBtest/jwtTest")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")

                .antMatchers("/DBtest/getProfile")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")

                .antMatchers("/DBtest/post_vote")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")

                .antMatchers("/DBtest/answer_vote")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll();


        return http.build();
    }

    public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder
                    .addFilter(new JwtAuthorizationFilter(authenticationManager,member_repository))
                    .addFilter(new JwtAuthenticationFilter(authenticationManager));
        }
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}