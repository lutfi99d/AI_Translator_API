package com.example.ai_Translator.domain

import kotlinx.serialization.Serializable

@Serializable
data class TranslationRequest(
    val text: String,
    val from: String?,
    val to : String
)
