package labs.spring.cloud.client;
import org.springframework.boot.*; import org.springframework.boot.autoconfigure.*; import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*; import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@SpringBootApplication @EnableFeignClients
public class ClientApp { public static void main(String[] args){ SpringApplication.run(ClientApp.class, args); } }
@RestController class Api {
  private final HttpBinClient http;
  Api(HttpBinClient http){ this.http = http; }
  @GetMapping("/ping") @CircuitBreaker(name="httpbin", fallbackMethod="fallback")
  public String ping(){ return http.get(); }
  String fallback(Throwable t){ return "fallback"; }
}
