package labs.spring.cloud.client;
import org.springframework.cloud.openfeign.FeignClient; import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name="httpbin", url="https://httpbin.org")
public interface HttpBinClient { @GetMapping("/get") String get(); }
