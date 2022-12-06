package tn.esprit.spring.kaddem.config;


import com.example.springfirstproject.repository.ContratRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    ContratRepository contratRepository;
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
    @Before("execution(* tn.esprit.spring.kaddem.service..*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("Method " + name + " is Launched: ");
    }
    @After("execution(* tn.esprit.spring.kaddem.service..*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("Method "+name+"has fully executed");
    }
    @AfterReturning("execution(* tn.esprit.spring.kaddem.service..*(..))")
    public void logMethodReturning(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("Function " + name + " Returned data: ");
    }
    @AfterThrowing("execution(* tn.esprit.spring.kaddem.service..*(..))")
    public void logMethodThrow(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("Method " + name + " Throwed an exception: ");
    }
    @Around("execution(* tn.esprit.spring.kaddem.service..*(..))")
    public void logMethodAround(ProceedingJoinPoint pjp) throws Throwable {
        Long s=System.currentTimeMillis();
        String name = pjp.getSignature().getName();
        Long elapsedTime = System.currentTimeMillis() - s;
        logger.info("Method " + name + " execution time: " + elapsedTime +
                " milliseconds.");
    }


}
