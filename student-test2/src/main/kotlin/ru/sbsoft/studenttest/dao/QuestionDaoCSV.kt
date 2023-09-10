package ru.sbsoft.studenttest.dao

import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import org.springframework.stereotype.Component
import ru.sbsoft.studenttest.config.QuestionStorageConfig
import ru.sbsoft.studenttest.domain.Question
import ru.sbsoft.studenttest.stereotype.LogEnable
import java.io.InputStreamReader

@Component
class QuestionDaoCSV(private val storageConfig: QuestionStorageConfig,
    private val questionBuilder: QuestionBuilder): QuestionDao {

    @LogEnable
    override fun readQuestions(): List<Question> {
        val parser = CSVParserBuilder().withSeparator(';').build()
        InputStreamReader(javaClass.classLoader.getResourceAsStream(storageConfig.questionFileName)).use {br ->
            CSVReaderBuilder(br).withCSVParser(parser).build().use {reader ->
                val result = mutableListOf<Question>()
                do {
                    val values = reader.readNext()
                    if (values != null) {
                        result.add(questionBuilder.build(values))
                    }
                } while(values != null)
                return result
            }
        }
    }
}
