package ru.sbsoft.studenttest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import ru.sbsoft.studenttest.service.ExaminerService

@SpringBootApplication
class StudentTest2Application

fun main(args: Array<String>) {
	val context = runApplication<StudentTest2Application>(*args)
	val exam = context.getBean(ExaminerService::class.java)
	exam.exam()
}
