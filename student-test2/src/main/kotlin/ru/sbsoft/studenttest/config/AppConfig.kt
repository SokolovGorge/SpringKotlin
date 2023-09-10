package ru.sbsoft.studenttest.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "test")
@Component
class AppConfig:  QuestionConfig, ExamConfig{
    lateinit var localeMap: Map<String, String>
    lateinit var localeDef: String
    override lateinit var questionFileName: String
    override var passCount:Int = 0
}
