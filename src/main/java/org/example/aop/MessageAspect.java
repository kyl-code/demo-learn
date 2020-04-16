package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.annotation.FeignMesage;
import org.example.model.RespBody;
import org.example.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author Adam_Guo
 * @Date 2020/4/10
 * @Version 1.0
 **/
@Aspect
@Component
public class MessageAspect {
    @Around("@annotation(org.example.annotation.FeignMesage)")
    public Object aroundMethod(final ProceedingJoinPoint joinPoint) {
        try {
            String methodName = joinPoint.getSignature().toString();
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            FeignMesage annotation = signature.getMethod().getAnnotation(FeignMesage.class);
            Object result = Arrays.asList(joinPoint.getArgs());
            System.out.println("The method name:" + methodName + "--value:" + result + "VALUE:" + annotation.value());
            return (RespBody<User>)joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    @Before("@annotation(org.example.annotation.FeignMesage)")
    public void beforeMethod(JoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            signature.getMethod().getAnnotation(FeignMesage.class);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
