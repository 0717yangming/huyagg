package com.ym.hygg.huyagg.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class CommodityAop {
    @Pointcut("execution(* com.ym.hygg.huyagg.service.*.*(..))")
    private void pointcutService(){}
    @Pointcut("execution(* com.ym.hygg.huyagg.controller.*.*(..))")
    private void pointcutController(){}

    @Before("pointcutController()")
    public void beforeController(){

    }
    @Around("pointcutService()")
    public Object getServiceTime(ProceedingJoinPoint pj){
        log.info("-----------------------------------");
        long start = System.currentTimeMillis();
        Object target = null;
        try {
            target = pj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info(pj.getSignature().getName()+" 执行时间: "+(end-start)+"ms");
        return target;
    }
}
