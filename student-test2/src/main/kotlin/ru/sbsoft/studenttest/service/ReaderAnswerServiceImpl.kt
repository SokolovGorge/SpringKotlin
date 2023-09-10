package ru.sbsoft.studenttest.service

import org.springframework.stereotype.Service
import ru.sbsoft.studenttest.domain.Answer
import ru.sbsoft.studenttest.domain.Question

@Service
class ReaderAnswerServiceImpl(private val readService: ReadService,
    private val writeService: WriteService,
    private val messageService: MessageService): ReaderAnswerService {
    override fun request(question: Question): Answer {
        writeService.write(messageService.getMessage("prompt.enter-number") + ":")
        var choice = readAnswer(question)
        if (choice < 0) {
            do {
                writeService.write(messageService.getMessage("prompt.invalid-choice") + ":")
                choice = readAnswer(question)
            } while (choice < 0)
        }
        return question.answers[choice - 1]
    }

    private fun readAnswer(question: Question): Int {
        val answer = readService.read()
        try {
            val choice = answer.toInt()
            if (choice > 0 && choice <= question.answers.size) {
                return choice
            }
            return -1
        } catch (ex: NumberFormatException) {
            return -1
        }
    }
}
