package labs.spring.core.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*; import org.springframework.stereotype.Component;
@Aspect @Component
public class LogAspect {
  @Before("execution(* labs.spring.core.service.*.*(..))")
  public void before(JoinPoint jp){ System.out.println("[AOP] Calling: " + jp.getSignature()); }
}
