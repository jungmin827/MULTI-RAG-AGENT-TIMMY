package com.emailassistant

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmailAssistantApplication

fun main(args: Array<String>) {
    runApplication<EmailAssistantApplication>(*args)
}

