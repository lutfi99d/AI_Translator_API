package com.example.ai_Translator.data

import com.example.ai_Translator.data.remote.AzureTranslationClient
import com.example.ai_Translator.domain.TranslationRequest
import com.example.ai_Translator.utils.Logger
import com.example.ai_Translator.utils.Result

class TranslationRepository(
    private val client : AzureTranslationClient,
    ){
    private val logger = Logger("TranslationRepository")

    suspend fun translate(request: TranslationRequest): Result<String>{
        return try {
            logger.log("Sending translation request: ${request.text} -> ${request.to}")
            val response = client.translate(request)
            logger.log("Received translation response: $response")
            Result.Success(response)
        } catch (e: Exception) {
            logger.error("Translation failed: ${e.message}")
            Result.Error("Translation failed: ${e.message}")
        }
    }
}




