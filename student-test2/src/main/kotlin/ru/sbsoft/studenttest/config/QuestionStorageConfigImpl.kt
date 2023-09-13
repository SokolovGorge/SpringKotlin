package ru.sbsoft.studenttest.config

import org.springframework.stereotype.Component
import org.springframework.util.StringUtils

@Component
class QuestionStorageConfigImpl(private val localeConfig: LocaleConfig, private val appConfig: AppConfig): QuestionStorageConfig {
    override val questionFileName: String
        get() {
            val fileName = appConfig.questionFileName
            val currentLocale = localeConfig.currentLocale
            if (currentLocale != null) {
                return StringUtils.stripFilenameExtension(fileName) + "_" + currentLocale.language + "_" + currentLocale.country + "." + StringUtils.getFilenameExtension(fileName)
            }
            return  fileName
        }
}
