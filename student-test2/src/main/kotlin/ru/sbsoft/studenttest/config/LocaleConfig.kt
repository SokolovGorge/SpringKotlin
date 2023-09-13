package ru.sbsoft.studenttest.config

import java.util.Locale

interface LocaleConfig {

    val localeMap: Map<String, String>

    val localeDef: String

    var currentLocale: Locale
}
