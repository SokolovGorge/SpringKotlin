package ru.sbsoft.studenttest.service

import org.springframework.stereotype.Service
import ru.sbsoft.studenttest.config.ExamConfig
import ru.sbsoft.studenttest.dao.QuestionDao
import ru.sbsoft.studenttest.domain.Question
import ru.sbsoft.studenttest.stereotype.LogEnable

@Service
class ExaminerServiceImpl(private val questionDao: QuestionDao,
    private val readerAnswerService: ReaderAnswerService,
    private val writeService: WriteService,
    private val messageService: MessageService,
    private val localeSelectionService: LocaleSelectionService,
    private val examConfig: ExamConfig): ExaminerService {

    @LogEnable
    override fun exam() {
        localeSelectionService.selectLocale()
        var goodAnswerCount = 0
        printExamStart()
        questionDao.readQuestions().forEach { question ->
            printQuestion(question)
            if (readerAnswerService.request(question).correct) {
                goodAnswerCount++
            }
        }
        printResult(goodAnswerCount >= examConfig.passCount)
    }

    private fun printExamStart() {
        writeService.writeln("************************************* ${messageService.getMessage("info.start-examination")} *********************************")
    }

    private fun printQuestion(question: Question) {
        writeService.writeln(messageService.getMessage("info.question") + ": " + question.question)
        writeService.writeln(messageService.getMessage("info.answer-choice"))
        question.answers.forEachIndexed { index, answer ->
            writeService.writeln("${index + 1}. ${answer.answer}")
        }
    }

    private fun printResult(result: Boolean) {
        writeService.writeln("******************************* ${messageService.getMessage("info.end-examination")} ******************************************")
        if (result) {
            writeService.writeln(messageService.getMessage("info.result-success"))
        } else {
            writeService.writeln(messageService.getMessage("info.result-fault"))
        }
        writeService.writeln("**********************************************************************************************")
    }
}
