package com.example.trip.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //로그인 처리를 구현하려면 SecurityConfig에서 AuthenticationManagerBuilder 인증 처리
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //csrf disable
        http
                .csrf(AbstractHttpConfigurer::disable);

        //From 로그인 방식 disable
        http
                .formLogin(form -> form
                        .loginPage("/login")//로그인 페이지 설정
                        .usernameParameter("user_id")
                        .passwordParameter("user_passwd")
                        .loginProcessingUrl("/loginProc")
                        .defaultSuccessUrl("/", true)//로그인 성공시 이동 url
                        .failureUrl("/login")//로그인 실패시 이동 url
                        .permitAll());
        http
                .logout(logout -> logout
                        .logoutSuccessUrl("/") // 로그아웃 후 리다이렉트할 경로 설정
                        .invalidateHttpSession(true));//세션 날리기

        //http basic 인증 방식 disable
        http
                .httpBasic(AbstractHttpConfigurer::disable);

        //경로별 인가 작업
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/login","/", "/join","/static/**", "/api/**").permitAll() //누구나 접근 허용
                        .anyRequest().authenticated());//나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근가능

        //세션 설정
        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();
    }
}
