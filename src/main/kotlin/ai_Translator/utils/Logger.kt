package com.example.ai_Translator.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Logger(private val tag: String) {

    private val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")

    fun log(message: String) {
        println("${LocalDateTime.now().format(formatter)} [INFO] [$tag]: $message")
    }

    fun error(message: String) {
        System.err.println("${LocalDateTime.now().format(formatter)} [ERROR] [$tag]: $message")
    }

}