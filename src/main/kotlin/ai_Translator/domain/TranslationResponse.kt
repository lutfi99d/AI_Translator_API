package com.example.ai_Translator.domain

import kotlinx.serialization.Serializable

@Serializable
data class TranslationResponse(
    val translatedText: String
)
