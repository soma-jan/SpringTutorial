package ProductService.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//custom annotation for aop-for logging request and response
//1.annotation declaration -@interface
//2.target definition
//3.Retention policy
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRequestResponse {
}
