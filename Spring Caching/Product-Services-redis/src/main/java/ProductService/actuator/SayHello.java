package ProductService.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="sayhello")
public class SayHello {

    @ReadOperation
    public String sayHello()
    {
     return "Hello-from-actuator class";
    }
    @ReadOperation
    public String sayHelloWithSelector(@Selector String name)
    {
        return "Hello"+name;
    }
}
