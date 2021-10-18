package com.yw.core.web.aspect;


import com.yw.core.base.mapper.JacksonMapper;
import com.yw.core.base.model.Weblog;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController)")
    public void webLog() {

    }


    @Before(value = "webLog()")
    public void dobefore(JoinPoint joinPoint) throws Throwable {

    }


    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {

    }

    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        LocalDateTime dateTime = LocalDateTime.now();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Weblog weblog = new Weblog();
        Object result = joinPoint.proceed();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(ApiOperation.class)){
            ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
            weblog.setDescription(apiOperation.value());
        }

        long endTime = System.currentTimeMillis();

        String urlStr = request.getRequestURL().toString();
        weblog.setBasePath("");
        weblog.setIp(request.getRemoteUser());
        weblog.setMethod(request.getMethod());
        weblog.setParameter(getParameter(method, joinPoint.getArgs()));
        weblog.setResult(result);
        weblog.setSpendTime((int) (endTime - startTime));
        weblog.setStartTime(dateTime);
        weblog.setUri(request.getRequestURI());
        weblog.setUrl(request.getRequestURL().toString());
        log.info("{}", JacksonMapper.toJson(weblog));
        return result;
    }

    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                Map<String, Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                argList.add(map);
            }

            PathVariable pathVariable = parameters[i].getAnnotation(PathVariable.class);
            if (pathVariable !=null){
                Map<String, Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(pathVariable.name())) {
                    key = pathVariable.name();
                }
                map.put(key, args[i]);
                argList.add(map);
            }

        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }



}
