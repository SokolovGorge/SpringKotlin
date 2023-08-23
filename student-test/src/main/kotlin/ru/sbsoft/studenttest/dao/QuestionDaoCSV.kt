package ru.sbsoft.studenttest.dao

import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.sbsoft.studenttest.domain.Question
import java.io.InputStreamReader

@Component
class QuestionDaoCSV(@Value("\${test.question.filename}") val csvFileName: String, val questionBuilder: QuestionBuilder): QuestionDao {

    override fun readQuestions(): List<Question> {
        val parser = CSVParserBuilder().withSeparator(';').build()
        InputStreamReader(requireNotNull(javaClass.classLoader.getResourceAsStream(csvFileName))).use { ism ->
            CSVReaderBuilder(ism).withCSVParser(parser).build().use{ r ->
                val result = mutableListOf<Question>()
                var values: Array<String>?
                do {
                    values = r.readNext()
                    if (values != null) {
                        result.add(questionBuilder.build(values))
                    }
                } while (values != null)
                return result
            }
        }
    }
}
