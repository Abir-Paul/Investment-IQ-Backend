package com.investmentiq.base.globalAspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    // Pointcut: all methods in classes annotated with @RestController
    @Around("within(@org.springframework.web.bind.annotation.RestController *)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        // Request start
        long start = System.currentTimeMillis();
        log.info("Started: {}.{} at {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), start);

        // Method execution
        Object result = joinPoint.proceed();

        // Request end
        long end = System.currentTimeMillis();
        log.info("Finished: {}.{} at {}, Duration: {} ms",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), end, (end - start));

        return result;
    }
}

