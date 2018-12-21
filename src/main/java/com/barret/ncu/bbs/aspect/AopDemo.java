package com.barret.ncu.bbs.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopDemo {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.barret.ncu.bbs.controller.UserController.*(..))")
    public Object LogAroundUserController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("进入控制器");
        Object args[] = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            logger.info("参数是:"+arg);
        }
        Object object = proceedingJoinPoint.proceed();
        logger.info("执行完成:");
        return object;
    }
}
