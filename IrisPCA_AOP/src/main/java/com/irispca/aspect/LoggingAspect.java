package com.irispca.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.irispca.service.*.*(..))")
    public void logMethod(JoinPoint joinPoint) {

        System.out.println(
                "[LOG] Çalışan metod: "
                        + joinPoint.getSignature().getName()
        );
    }
}