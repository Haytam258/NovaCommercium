package com.novacommercium.nova.aspect;

import ch.qos.logback.classic.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


@Aspect
@Configuration
public class TraceInvocation {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TraceInvocation.class);

    @Pointcut("execution(* com.novacommercium.nova.services.ProduitService..*(..))")
    public void traceInvocationPointcut() { }

    @Pointcut("execution(* com.novacommercium.nova.services.MatiereService..*(..))")
    public void traceMatierePointcut() { }

    @Pointcut("execution(* com.novacommercium.nova.services.OrigineService..*(..))")
    public void traceOriginePointcut() { }

    @Around("traceInvocationPointcut() || traceMatierePointcut() || traceOriginePointcut()")
    public Object afficherTrace( ProceedingJoinPoint joinpoint) throws Throwable {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nomMethode = joinpoint.getTarget().getClass().getSimpleName() + "."
                + joinpoint.getSignature().getName();
        Object obj =joinpoint.proceed();
        if( principal.getUsername() != null) {
            logger.warn("User " + principal.getUsername() + " used : " + nomMethode);
        }
        return obj;
    }


}
