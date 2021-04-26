package com.bootgrdle.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangqx
 * @Date: 2021/2/19 15:00
 * @Description:
 */
@Aspect
@Slf4j
@Component
public class LogAspect {
    /**
     * controller切点
     */
    @Pointcut("execution(* com.bootgrdle.demo.controller.*Controller.*(..))")
    private void pointCutMethodController() {
    }

    /**
     * service切点
     */
    @Pointcut("execution(* com.bootgrdle.demo.service.impl.*Impl.*(..))")
    private void pointCutMethodService() {
    }
    /*
     *  声明前置通知 ，JoinPont是spring提供的静态变量，
     *  通过joinPoint参数可以获得目标方法的类名，方法参数，方法名等信息，这个参数可有可无。
     */

//    @Before("pointCutMethodController()")
    public void doBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        StringBuilder logs = new StringBuilder();
        logs.append("before: ")
                .append(className)
                .append("@")
                .append(methodName)
                .append(" , params: ");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logs.append(JSONObject.toJSONString(arg)).append(", ");
        }
        log.info(logs.toString());
    }
    /**
     * 声明后置通知 ，如果result的类型与proceed执行的方法返回的参数类型不匹配那么就不会执行这个方法
     */
    @AfterReturning(pointcut = "pointCutMethodController()", returning = "result")
    public void doAfterReturning(String result) {
        log.info("---" + result + "---");
    }

    /**
     * 声明例外通知
     */
    @AfterThrowing(pointcut = "pointCutMethodController()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        log.error("afterThrowing: "+e.getMessage(), e);
    }

    /**
     *  声明最终通知
     */
    @After("pointCutMethodController()")
    public void doAfter() {
//        log.info("after");
    }
    /*
     * 声明环绕通知
     * 参数必须是ProceedingJoinPoint，通过该对象的proceed()方法来执行目标函数，
     * proceed()的返回值就是环绕通知的返回值，proceedingJoinPoint是个接口，
     * implement JoinPoint,所以也可以获得目标函数的类名，方法名等参数。
     */

    @Around("pointCutMethodController()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
            Long begin = System.currentTimeMillis();
            StringBuilder logs = new StringBuilder("around: ");
            Object result = null;
            try {
                result = pjp.proceed();
            } catch (Exception e) {
                log.error(logs + e.getMessage(), e);
            }
            Long end = System.currentTimeMillis();
            logs.append(" 执行时间: ").append(end-begin).append("ms");
            log.info(logs.toString());
            return result;
    }
}
