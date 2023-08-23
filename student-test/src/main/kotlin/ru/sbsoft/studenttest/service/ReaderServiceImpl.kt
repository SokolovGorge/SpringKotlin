package ru.sbsoft.studenttest.service

import java.io.InputStream
import java.util.*

class ReaderServiceImpl(input: InputStream): ReaderService {

    private val scanner = Scanner(input)

    override fun read(): String {
        return scanner.next()
    }
}
