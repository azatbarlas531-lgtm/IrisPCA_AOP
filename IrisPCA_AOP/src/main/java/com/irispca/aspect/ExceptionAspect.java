package com.irispca.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionAspect {

    @AfterThrowing(
            pointcut = "execution(* com.irispca.service.*.*(..))",
            throwing = "ex")
    public void handleException(Exception ex) {

        System.out.println(
                "[HATA] " + ex.getMessage()
        );
    }
}