package com.example.ai_Translator.data.remote

import com.example.ai_Translator.domain.TranslationRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AzureTranslationClient(
    private val httpClient: HttpClient,
    private val azureKey: String,
    private val azureRegion: String,
    private val azureEndPoints: String
){
private val translateUrl ="$azureEndPoints/translate?api-version=3.0"

    suspend fun translate(request: TranslationRequest): String{
        val langQuery=if(request.from !=null){
            "&to=${request.to}&from=${request.from}"
        }else{
            "&to=${request.to}"
        }
        val response =httpClient.post("$translateUrl$langQuery"){
            header("Ocp-Apim-Subscription-Key", azureKey)
            header("Ocp-Apim-Subscription-Region", azureRegion)
            contentType(ContentType.Application.Json)
            setBody(listOf(mapOf("Text" to request.text)))
        }

        return response.body<String>()
    }
}


