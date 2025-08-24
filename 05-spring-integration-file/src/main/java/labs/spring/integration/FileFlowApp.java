package labs.spring.integration;
import org.springframework.boot.*; import org.springframework.boot.autoconfigure.*; import org.springframework.context.annotation.*;
import org.springframework.integration.dsl.*; import org.springframework.integration.file.dsl.Files;
import java.io.File;
@SpringBootApplication
public class FileFlowApp {
  public static void main(String[] args){ SpringApplication.run(FileFlowApp.class, args); }
  @Bean IntegrationFlow flow(){
    File in = new File("inbox"); in.mkdirs();
    return IntegrationFlows.from(Files.inboundAdapter(in).autoCreateDirectory(true), c->c.poller(Pollers.fixedDelay(2000)))
      .transform(File.class, File::getName)
      .handle(System.out::println)
      .get();
  }
}
