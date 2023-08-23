package ru.sbsoft.studenttest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.sbsoft.studenttest.service.ReaderService
import ru.sbsoft.studenttest.service.ReaderServiceImpl
import ru.sbsoft.studenttest.service.WriterService
import ru.sbsoft.studenttest.service.WriterServiceImpl

@Configuration
class UtilServiceConfig {

    @Bean
    fun writeService(): WriterService = WriterServiceImpl(System.out)

    @Bean
    fun readerService(): ReaderService = ReaderServiceImpl(System.`in`)

}
