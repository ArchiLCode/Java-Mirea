package org.example.practice22;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ServiceExecutionTimeAspect {
    private long startTime;

    @Before("execution(* org.example.practice22.ServiceDB.*(..))")
    public void beforeMethodExecution() {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* org.example.practice22.ServiceDB.*(..))")
    public void afterMethodExecution(JoinPoint joinPoint) {
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("Метод " + joinPoint.getSignature() + " выполнен за " + executionTime + " мс");
    }
}
