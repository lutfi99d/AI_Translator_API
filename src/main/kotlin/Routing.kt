package com.example

import com.example.ai_Translator.app.routes.healthRoute
import com.example.ai_Translator.app.routes.translateRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        healthRoute()
        translateRoute()
    }
}
