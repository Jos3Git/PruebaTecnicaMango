import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.company")
@ImportResource("classpath:com/company/app/spring-config.xml")
public class SpringConfig {

}
