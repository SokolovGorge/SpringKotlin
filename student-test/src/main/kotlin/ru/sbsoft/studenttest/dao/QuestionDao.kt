package ru.sbsoft.studenttest.dao

import ru.sbsoft.studenttest.domain.Question

interface QuestionDao {

    fun readQuestions(): List<Question>
}
