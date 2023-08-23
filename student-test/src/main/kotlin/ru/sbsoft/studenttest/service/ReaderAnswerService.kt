package ru.sbsoft.studenttest.service

import ru.sbsoft.studenttest.domain.Answer
import ru.sbsoft.studenttest.domain.Question

interface ReaderAnswerService {

    fun request(question: Question): Answer
}
