package com.skillstorm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {
	
	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	/*
	 * Aspects have Advice that run at some point
	 *      - Join Point = the place in your code 
	 *      - Point cut = the definition in the Aspect of where those Join Points exist
	 *      
	 *      - Advice = the code that needs to run to handle this aspect
	 */
	
	/*
	 * To define a pointcut use @Pointcut("execution(method signature goes here)")
	 * - Note the method signature can be exact or use wildcards
	 * - If specifying a classtype, give the full name including package
	 * - You can use two different wildcards
	 *     * matches exactly 1 of something
	 *     .. matches 0 or more of something
	 * Note: you can't start with .. so for any number of packages use execution(*..set*(*))
	 */
//	@Pointcut("execution(void *..models.get*(*))")
//	public void getters() {
//		
//	}
	
//	@Pointcut("@annotation(com.skillstorm.aspects.annotations.Loggable)")
//	public void loggableMethods() {}
//	
	@Pointcut("within(com.skillstorm.repositories..*)")
	public void loggingRepository() {}
	
	@Before("loggingRepository()")
	public void logMethod(JoinPoint jp) {
	    String methodName = jp.getSignature().getName();
	    logger.info("Executing method: " + methodName);
	}
//	
//	@Pointcut("execution(public * saveDirector(com.skillstorm.models.Director)) && args(directorToBeSaved)")
//	public void checkDirector(Director directorToBeSaved) {
//		
//	}
	
	
	/*@After(value ="getters()") 
	public void logChanges(JoinPoint joinPoint, Object objReturned) {
		String signature = joinPoint.getSignature().toString();
		Object[] args = joinPoint.getArgs();
		Object arg = args[0];
		
		logger.debug("=================================================");
		logger.debug("Method running " + signature);
		logger.debug("arg handed in is " + arg);
		logger.debug("=================================================");
		
	}*/
	
	 /*
     * Types of advice
     *      Before - advice runs before method execution
     *      After - advice runs after method execution
     *      AfterReturning - advice runs after method execution ONLY when it returns something
     *      AfterThrowing - advice runs after method execution ONLY when it throws an exception
     *      Around - all of the above
     */     
//	@AfterThrowing("setters()")
//	public void logSomeMore(JoinPoint joinPoint, Throwable e) {
//		
//	}
	
//	@Around("checkDirector(directorToBeSaved)")
//    public Director logDirectors(ProceedingJoinPoint proceedingJoinPoint, Director directorToBeSaved) {
//        // PROCEEDING JOIN POINT
//        // - join point that has an extra method: .proceed()
//        // aspect is going to interrupt a method and do something - then that method gets executed
//        // with a proceeding join point, it WILL NOT execute that method, unless you call .proceed()
//        // THESE ARE ONLY AVAILABLE ON AROUND ADVICE - errors on any other type of advice
//
//		
//        logger.debug("DIRECTOR: ", directorToBeSaved.toString());
//
//        /*
//         * making a couple of assumptions:
//         *      1. id will never be 0 in your database
//         *      2. front end won't generate IDs for new records
//         */
//        if(directorToBeSaved.getId() == 0) {
//            try {
//                proceedingJoinPoint.proceed();
//            } catch (Throwable e) {
//                logger.error("Method could not beexecuted.", e);
//            }
//
//            logger.debug("DIRECTOR WAS CREATED");
//        }
//        else {
//            logger.debug("DIRECTOR WAS NOT CREATED - ALREADY EXISTS");
//        }
//
//        return directorToBeSaved;
//    }
//	
//	
//	@AfterReturning
//	
//	
	

}
