package ProductService.aop;

import org.apache.coyote.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
/*This Aspect is a module which is responsible
 * for logging all requests and response where we apply the
 * LogRequestResponse annotation*/
@Aspect
@Component
public class RequestResponseLoggingAspect {
    @Pointcut("@annotation(ProductService.aop.LogRequestResponse)")
    public void logAnnotationPointCut()
    {

    }

    @Before("logAnnotationPointCut()")
    public void logBefore(JoinPoint joinpoint)
    {
        System.out.println("Before :"+joinpoint.getSignature().getName());
    }

    @After("logAnnotationPointCut()")
    public void logAfter(JoinPoint joinpoint)
    {
        System.out.println("After :"+joinpoint.getSignature().getName());
    }
    @AfterReturning(pointcut = "logAnnotationPointCut()", returning ="result")
    public void logAfterReturning(JoinPoint joinpoint, Object result)
    {

        if(result instanceof ResponseEntity)
        {
            ResponseEntity<Object> response =(ResponseEntity)result;
            System.out.println("After returning  "+response.getStatusCode());
        }
    }


}
