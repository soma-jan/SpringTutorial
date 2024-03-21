package ProductService.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeLoggingAspect {

    @Pointcut("@annotation(ProductService.aop.LogExecutionTime)")
    public void logExecutiontimePointCut()
    {

    }
    @Around("@annotation(LogExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinpoint) throws Throwable {
        long start =System.currentTimeMillis();
        Object proceed=joinpoint.proceed();
        long executionTime =System.currentTimeMillis()-start;
        System.out.println("Current method executed :"+joinpoint.getSignature().getName() +
                            "Execution Time:"+executionTime);
        return  proceed;
    }
}
