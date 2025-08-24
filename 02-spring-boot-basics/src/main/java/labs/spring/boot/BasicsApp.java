package labs.spring.boot;
import org.springframework.boot.*; import org.springframework.boot.autoconfigure.*; import org.springframework.web.bind.annotation.*;
@SpringBootApplication
public class BasicsApp { public static void main(String[] args){ SpringApplication.run(BasicsApp.class, args); } }
@RestController @RequestMapping("/api")
class Api { @GetMapping("/hello") String hello(){ return "Hello Boot"; } }
