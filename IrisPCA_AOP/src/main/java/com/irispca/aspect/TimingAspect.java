package com.irispca.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimingAspect {

    @Around("execution(* com.irispca.service.*.*(..))")
    public Object calculateTime(
            ProceedingJoinPoint joinPoint)
            throws Throwable {

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println(
                "[SÜRE] "
                        + joinPoint.getSignature().getName()
                        + " : "
                        + (end - start)
                        + " ms");

        return result;
    }
}