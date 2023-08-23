package ru.sbsoft.studenttest

import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.PropertySource
import ru.sbsoft.studenttest.service.ExaminerService

@SpringBootApplication
@PropertySource("application.properties")
class StudentTestApplication

fun main(args: Array<String>) {
	val context = AnnotationConfigApplicationContext(StudentTestApplication::class.java)
	val examinerService: ExaminerService = context.getBean(ExaminerService::class)
	examinerService.exam()
}
