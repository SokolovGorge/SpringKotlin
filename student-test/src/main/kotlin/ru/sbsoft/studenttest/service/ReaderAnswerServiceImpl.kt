package ru.sbsoft.studenttest.service

import org.springframework.stereotype.Service
import ru.sbsoft.studenttest.domain.Answer
import ru.sbsoft.studenttest.domain.Question

@Service
class ReaderAnswerServiceImpl(val readerService: ReaderService, val writerService: WriterService): ReaderAnswerService {
    override fun request(question: Question): Answer {
        writerService.print("Enter number of choice:")
        var choice = readAnswer(question)
        if (choice < 0) {
            do {
                writerService.print("Invalid choice, try again:")
                choice = readAnswer(question)
            } while (choice < 0)
        }
        return question.answers[choice - 1]
    }

    private fun readAnswer(question: Question): Int {
        val answer = readerService.read()
        try {
            val choice = answer.toInt()
            if (choice > 0 && choice <= question.answers.size) {
                return choice
            }
            return -1
        } catch (e: NumberFormatException) {
            return -1
        }
    }
}
