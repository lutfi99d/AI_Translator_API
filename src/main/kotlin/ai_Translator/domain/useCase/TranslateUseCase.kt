package com.example.ai_Translator.domain.useCase


import com.example.ai_Translator.data.TranslationRepository
import com.example.ai_Translator.domain.TranslationRequest
import com.example.ai_Translator.utils.Result
import com.example.ai_Translator.utils.Logger

class TranslateUseCase(
    private val repository: TranslationRepository
) {
    private val logger = Logger("TranslateUseCase")

    suspend operator fun invoke(request: TranslationRequest): Result<String> {
        if (request.text.isBlank()) {
            logger.error("Validation failed: text is empty")
            return Result.Error("Text cannot be empty")
        }

        if (request.to.isBlank()) {
            logger.error("Validation failed: target language is missing")
            return Result.Error("Target language (to) cannot be empty")
        }

        logger.log("Processing translation use case for: ${request.text}")
        return repository.translate(request)
    }
}