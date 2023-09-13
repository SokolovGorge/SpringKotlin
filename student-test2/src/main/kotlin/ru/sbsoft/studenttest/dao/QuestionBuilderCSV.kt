package ru.sbsoft.studenttest.dao

import org.springframework.stereotype.Component
import ru.sbsoft.studenttest.domain.Answer
import ru.sbsoft.studenttest.domain.Question

@Component
class QuestionBuilderCSV: QuestionBuilder {
    override fun build(values: Array<String>): Question {
        require(values.size == 2) {"Build question error: string array length not equal 2"}
        return Question(values[0], convertString2List(values[1]))
    }

    private fun convertString2List(value: String): List<Answer> {
        if (value.isEmpty()) {
            return emptyList()
        }
        val values = value.split("""|""")
        return List(values.size) {index ->  convert2Answer(values[index])}
    }

    private fun convert2Answer(st: String): Answer {
        val ch = st[0]
        require(ch == '0' || ch == '1') {"Unexpected first char in answer $ch"}
        return Answer(st.substring(1), ch == '1')
    }
}
