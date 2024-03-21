package ProductService.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application-prod.properties")
public class ProfileDemo {
    @Value("${message}")
    private String message;
    @PostConstruct
    public void printMessage()
    {
        System.out.println(message);
    }
}
