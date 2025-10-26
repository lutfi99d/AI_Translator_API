package com.example.ai_Translator.app.di

import com.example.ai_Translator.data.TranslationRepository
import com.example.ai_Translator.data.remote.AzureTranslationClient
import com.example.ai_Translator.domain.useCase.TranslateUseCase
import com.example.ai_Translator.utils.ConfigLoader
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

object AppModule {
    val httpClient: HttpClient by lazy {
        HttpClient(CIO)
    }

    val azureClient : AzureTranslationClient by lazy {
        AzureTranslationClient(
            httpClient = httpClient,
            azureKey = ConfigLoader.azureKey,
            azureRegion = ConfigLoader.azureRegion,
            azureEndPoints = ConfigLoader.azureEndpoint
        )
    }

    val translationRepository: TranslationRepository by lazy {
        TranslationRepository(azureClient)
    }

    val translateUseCase: TranslateUseCase by lazy {
        TranslateUseCase(translationRepository)
    }
}