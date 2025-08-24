package labs.spring.security;
import org.springframework.boot.*; import org.springframework.boot.autoconfigure.*; import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;
@SpringBootApplication
public class SecApp { public static void main(String[] args){ SpringApplication.run(SecApp.class, args); }
  @Bean SecurityFilterChain filter(HttpSecurity http) throws Exception {
    http.csrf(csrf->csrf.disable()).authorizeHttpRequests(a->a.requestMatchers("/public/**").permitAll().anyRequest().authenticated()).httpBasic();
    return http.build();
  }
}
@RestController @RequestMapping("/api")
class Api { @GetMapping("/public/ping") String ping(){ return "pong"; } @GetMapping("/secure/hello") String hello(){ return "secret"; } }
