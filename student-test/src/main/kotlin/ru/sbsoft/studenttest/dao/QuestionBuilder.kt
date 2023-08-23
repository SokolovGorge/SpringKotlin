package ru.sbsoft.studenttest.dao

import ru.sbsoft.studenttest.domain.Question

interface QuestionBuilder {

    fun build(values: Array<String>): Question
}
