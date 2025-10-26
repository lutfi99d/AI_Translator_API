package com.example.ai_Translator.app.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import kotlin.collections.mapOf

fun Route.healthRoute(){

    get("/health"){
        try {
            call.respond(
                message = "Server is running successfully",
                status = HttpStatusCode.OK
            )
        }catch (e: Exception){
            call.respond(
                message = mapOf("error" to e.message),
                status = HttpStatusCode.InternalServerError
            )
        }
    }
}