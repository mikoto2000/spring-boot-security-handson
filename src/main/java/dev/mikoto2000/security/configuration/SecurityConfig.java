package dev.mikoto2000.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig
 */
@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // ログインフォームを自作し、ログイン関連 URL は誰でもアクセスできるよう指定
    // ログイン失敗時には "/login?error" へリダイレクトする
    http.formLogin(login -> {
      login
        .loginPage("/login")
        .permitAll()
        .failureUrl("/login?error");
    })
    // ログアウトは、画面の自作はせず
    // POST する URL とログアウト成功後のリダイレクト URL を指定する
    .logout(logout -> logout
        .logoutUrl("/logout")
        .logoutSuccessUrl("/"))
    .authorizeHttpRequests(auth -> {
      auth
        /* 修正ここから */
        // "/" は誰でも表示できる
        .requestMatchers("/").permitAll()
        // "/signup", "/admin/**" は ADMIN しか表示できない
        .requestMatchers("/signup").hasRole("ADMIN")
        .requestMatchers("/admin/**").hasRole("ADMIN")
        /* 修正ここまで */
        // その他ページは、ログイン済みでないと表示できない
        .anyRequest().authenticated();
    });
    return http.build();
  }

  /* 修正ここから(PasswordEncoder Bean 定義を追加) */
  /**
   * Spring Security で使用する PasswordEncoder を定義。
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
  /* 修正ここまで */
}
