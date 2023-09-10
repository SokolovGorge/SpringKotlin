package ru.sbsoft.studenttest.service

import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import ru.sbsoft.studenttest.config.LocaleConfig
import java.util.*

@Service
class MessageServiceImpl(private val localeConfig: LocaleConfig,
    private val messageSource: MessageSource): MessageService {
    override fun getMessage(code: String, vararg args: Any): String {
        return messageSource.getMessage(code, args, localeConfig.currentLocale)
    }
}
