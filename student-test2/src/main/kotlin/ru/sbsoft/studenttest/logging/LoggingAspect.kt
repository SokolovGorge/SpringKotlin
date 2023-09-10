package ru.sbsoft.studenttest.logging

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAspect {

    @Before("@annotation(ru.sbsoft.studenttest.stereotype.LogEnable)")
    fun logBefore(joinPoint: JoinPoint) {
        println("---")
        println("Class: ${joinPoint.target.javaClass.name}")
        println("Proxy: ${joinPoint.`this`.javaClass.name}")
        println("Call method: ${joinPoint.signature.name}")
        println("---")
    }
}
