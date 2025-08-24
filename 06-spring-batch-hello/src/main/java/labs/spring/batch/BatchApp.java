package labs.spring.batch;
import org.springframework.batch.core.*; import org.springframework.batch.core.configuration.annotation.*; import org.springframework.batch.core.job.builder.*; 
import org.springframework.batch.core.step.builder.*; import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.*; import org.springframework.boot.autoconfigure.*; import org.springframework.context.annotation.Bean;
@SpringBootApplication @EnableBatchProcessing
public class BatchApp {
  public static void main(String[] args){ SpringApplication.run(BatchApp.class, args); }
  @Bean Job job(JobRepository repo, PlatformTransactionManager tx){
    Step step = new StepBuilder("helloStep", repo).tasklet((c, ctx)->{ System.out.println("Hello Spring Batch"); return RepeatStatus.FINISHED; }, tx).build();
    return new JobBuilder("helloJob", repo).start(step).build();
  }
}
