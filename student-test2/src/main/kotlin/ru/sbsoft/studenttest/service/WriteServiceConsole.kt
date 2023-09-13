package ru.sbsoft.studenttest.service

import org.springframework.stereotype.Service

@Service
class WriteServiceConsole: WriteService {
    override fun writeln(x: String) {
        println(x)
    }

    override fun write(x: String) {
        print(x)
    }
}
