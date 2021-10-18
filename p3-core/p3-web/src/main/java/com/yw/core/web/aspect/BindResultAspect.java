package com.yw.core.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class BindResultAspect {

    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController)")
    public void bindresult() {
    }


    @Before(value = "bindresult()")
    public void dobefore(JoinPoint joinPoint) throws Throwable {

    }


    @AfterReturning(value = "bindresult()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {

    }


    @Around(value = "bindresult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    log.error("loggger:------:" + result.getFieldError().getDefaultMessage());
                    return result.getFieldError().getDefaultMessage();
                }
            }
        }
        return joinPoint.proceed();
    }


}
