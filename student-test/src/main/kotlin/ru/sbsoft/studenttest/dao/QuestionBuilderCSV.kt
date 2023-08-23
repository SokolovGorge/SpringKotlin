package ru.sbsoft.studenttest.dao

import org.springframework.stereotype.Component
import ru.sbsoft.studenttest.domain.Answer
import ru.sbsoft.studenttest.domain.Question
import ru.sbsoft.studenttest.exceptions.QuestionException

@Component
class QuestionBuilderCSV: QuestionBuilder {
    override fun build(values: Array<String>): Question {
        if (values.size != 2) {
            throw QuestionException("Build question error: string array length not equal 2")
        }
        return Question(values[0], convertString2List(values[1]))
    }

    private fun convertString2List(value: String?): List<Answer> {
        if (value.isNullOrEmpty()) {
            return emptyList()
        }
        val values = value.split("|")
        return List(values.size) { index -> buildAnswer(values[index]) }
    }

    private fun buildAnswer(st: String): Answer {
        val ch = st[0]
        if (ch != '0' && ch != '1') {
            throw QuestionException("Unexpected first char in answer: $ch")
        }
        return Answer(st.substring(1), ch == '1')
    }

}
