package com.example.ai_Translator.app.routes

import com.example.ai_Translator.app.di.AppModule
import com.example.ai_Translator.domain.TranslationRequest
import com.example.ai_Translator.utils.Result
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import kotlin.collections.mapOf

fun Route.translateRoute(){
    post ("/translate"){
        try {
            val request=call.receive<TranslationRequest>()
            val result= AppModule.translateUseCase(request)

            when(result){
                is Result.Success -> {
                    call.respond(
                        message = mapOf("translated text" to result.data),
                        status = HttpStatusCode.OK
                    )
                }
                is Result.Error -> {
                    call.respond(
                        message =mapOf("error" to result.message),
                        status = HttpStatusCode.BadRequest
                    )
                }
            }

        }catch (e: Exception){
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = mapOf(
                    "error" to (e.message ?: "Unexpected error occurred")
                )
            )
        }
    }
}