package ru.sbsoft.studenttest.service

interface MessageService {
    fun getMessage(code: String, vararg args: Any): String
}
