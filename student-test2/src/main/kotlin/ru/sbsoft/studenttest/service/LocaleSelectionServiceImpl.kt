package ru.sbsoft.studenttest.service

import org.springframework.stereotype.Service
import ru.sbsoft.studenttest.config.LocaleConfig
import java.util.Locale

@Service
class LocaleSelectionServiceImpl(private val writeService: WriteService,
    private val readService: ReadService,
    private val localeConfig: LocaleConfig): LocaleSelectionService {

    override fun selectLocale() {
        writeService.write("Input code Locale:")
        val code = readService.read()
        val codeLang = localeConfig.localeMap[code.lowercase()]
        if (codeLang != null) {
            localeConfig.currentLocale = Locale.forLanguageTag(codeLang)
        } else {
            localeConfig.currentLocale = Locale.forLanguageTag(localeConfig.localeDef)
            writeService.writeln("Unknown locale $code. Set default locale ${localeConfig.localeDef}")
        }
    }
}
