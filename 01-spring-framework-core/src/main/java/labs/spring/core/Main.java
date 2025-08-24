package labs.spring.core;
import labs.spring.core.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
  public static void main(String[] args){
    try (var ctx = new AnnotationConfigApplicationContext(AppConfig.class)){
      var svc = ctx.getBean(GreetingService.class);
      System.out.println(svc.hello("Spring Core"));
    }
  }
}
