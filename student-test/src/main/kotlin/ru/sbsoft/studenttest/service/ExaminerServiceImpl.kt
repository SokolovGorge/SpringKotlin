package ru.sbsoft.studenttest.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import ru.sbsoft.studenttest.dao.QuestionDao
import ru.sbsoft.studenttest.domain.Question
import ru.sbsoft.studenttest.exceptions.QuestionException

@Service
class ExaminerServiceImpl(
    val questionDao: QuestionDao,
    val readerAnswerService: ReaderAnswerService,
    val writerService: WriterService,
    @Value("\${test.passCount}")
    val passingCount: Int
) : ExaminerService {
    override fun exam() {
        try {
            var goodAnswersCount = 0
            printExamStart()
            questionDao.readQuestions().forEach {question ->
                printQuestion(question)
                val answer = readerAnswerService.request(question)
                if (answer.correct) {
                    goodAnswersCount++
                }
            }
            printResult(goodAnswersCount >= passingCount)
        } catch (e: QuestionException) {
            writerService.println("An error occurred while completing the task: ${e.localizedMessage}")
        }
    }

    private fun printExamStart() {
        writerService.println("*********************** Start examination *********************************")
    }

    private fun printQuestion(question: Question) {
        writerService.println("Question: ${question.question}")
        writerService.println("Answer choice")
        question.answers.forEachIndexed { index, answer -> writerService.println("${index + 1} . ${answer.answer}") }
    }

    private fun printResult(result: Boolean) {
        writerService.println("*********************** End examination *********************************")
        if (result) {
            writerService.println("You have successfully passed the exam!")
        } else {
            writerService.println("You didn't pass the exam. Try again.")
        }
        writerService.println("*************************************************************************")
    }
}
