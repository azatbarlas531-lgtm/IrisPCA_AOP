package com.irispca.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ValidationAspect {

    @Before("execution(* com.irispca.service.*.*(..))")
    public void validate() {

        System.out.println(
                "[VALIDATION] Veri kontrolü yapıldı."
        );
    }
}