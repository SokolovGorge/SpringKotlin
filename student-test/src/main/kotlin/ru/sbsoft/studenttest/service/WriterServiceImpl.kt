package ru.sbsoft.studenttest.service

import java.io.PrintStream

class WriterServiceImpl(private val out: PrintStream): WriterService {
    override fun println(x: String) {
        out.println(x)
    }

    override fun print(x: String) {
        out.print(x)
    }
}
