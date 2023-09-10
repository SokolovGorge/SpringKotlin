package ru.sbsoft.studenttest.dao

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.sbsoft.studenttest.domain.Answer
import ru.sbsoft.studenttest.domain.Question

@DisplayName("Класс QuestionBuilderCSV")
class QuestionBuilderCSVTest {

    val instance = QuestionBuilderCSV()

    @DisplayName("Создание Question")
    @Test
    fun buildTest() {
        val csvStrings = arrayOf("Question1", "1Answer1|0Answer2")
        val expQuestion = Question("Question1", listOf(Answer("Answer1", true), Answer("Answer2", false)))

        val question = instance.build(csvStrings)
        assertEquals(expQuestion, question)
    }

    @DisplayName("Тест исключений")
    @Test
    fun exceptionTest() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            instance.build(
                arrayOf(
                    "Test1",
                    "Test2",
                    "Test3"
                )
            )
        }
        assertTrue(exception.message != null && exception.message!!.endsWith("length not equal 2"))
    }
}
