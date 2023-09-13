package ru.sbsoft.studenttest.service

import org.springframework.stereotype.Service

@Service
class ReadServiceConsole: ReadService {
    override fun read(): String {
        return readLine()?: ""
    }
}
