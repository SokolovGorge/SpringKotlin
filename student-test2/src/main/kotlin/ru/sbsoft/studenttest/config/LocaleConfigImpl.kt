package ru.sbsoft.studenttest.config

import org.springframework.stereotype.Component
import java.util.*

@Component
class LocaleConfigImpl(val appConfig: AppConfig
) : LocaleConfig {
    override val localeMap: Map<String, String>
        get() = appConfig.localeMap
    override val localeDef: String
        get() = appConfig.localeDef

    override lateinit var currentLocale: Locale

}
