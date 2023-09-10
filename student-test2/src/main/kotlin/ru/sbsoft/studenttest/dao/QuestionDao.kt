package ru.sbsoft.studenttest.dao

import ru.sbsoft.studenttest.domain.Question
import ru.sbsoft.studenttest.stereotype.LogEnable

interface QuestionDao {

    fun readQuestions(): List<Question>
}
