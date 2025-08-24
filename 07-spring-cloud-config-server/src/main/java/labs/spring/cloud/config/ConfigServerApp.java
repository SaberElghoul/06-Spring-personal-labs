package labs.spring.cloud.config;
import org.springframework.boot.*; import org.springframework.boot.autoconfigure.*; import org.springframework.cloud.config.server.EnableConfigServer;
@SpringBootApplication @EnableConfigServer
public class ConfigServerApp { public static void main(String[] args){ SpringApplication.run(ConfigServerApp.class, args); } }
