package com.example.ai_Translator.utils

import io.github.cdimascio.dotenv.Dotenv

object ConfigLoader {
    private val dotenv: Dotenv = Dotenv.load()

    val azureKey: String = dotenv["AZURE_KEY"] ?: error("AZURE_KEY not found in .env")
    val azureRegion: String = dotenv["AZURE_REGION"] ?: error("AZURE_REGION not found in .env")
    val azureEndpoint: String = dotenv["AZURE_ENDPOINT"] ?: error("AZURE_ENDPOINT not found in .env")
}