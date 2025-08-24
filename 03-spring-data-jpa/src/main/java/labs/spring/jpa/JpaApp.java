package labs.spring.jpa;
import org.springframework.boot.*; import org.springframework.boot.autoconfigure.*; import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.*; import jakarta.persistence.*; import java.util.List;
@SpringBootApplication
public class JpaApp {
  public static void main(String[] args){ SpringApplication.run(JpaApp.class, args); }
  @Bean CommandLineRunner init(UserRepo repo){ return args -> { repo.save(new User(null,"Saber")); System.out.println(repo.findAll().size()); }; }
}
@Entity class User { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; String name;
  User(){} User(Long id,String name){this.id=id;this.name=name;} public Long getId(){return id;} public String getName(){return name;} public void setName(String n){this.name=n;}
}
interface UserRepo extends JpaRepository<User,Long>{ List<User> findByNameContaining(String q); }
