# AI Translator API 🤖

A simple backend API built with **Ktor (Kotlin)** that translates text between languages using **Azure Translator API**.

---

## 🚀 How to Run Project

1. Clone the repository: git clone <your-repo-url>
2. Navigate into the project directory: cd ai-translator
3. Make sure you have **JDK 17+** installed
4. Build and run the Ktor server: ./gradlew run
5. The server will run at: http://0.0.0.0:8081/

## 🏗 Project Structure (Overview)
```
├── app/       🗂  # Ktor app entry (routes, config)
├── domain/    📦  # Business logic (models, use cases)
├── data/      🗃  # External data sources (repository, remote client)
├── utils/     🛠  # Logger, Result wrapper, Config loader
├── resources/ 🌐  # application.conf
├── .env
├── build.gradle.kts
├── README.md
└── .gitignore
```

## 🔑 How to Set Up Azure Key

1. Sign in to [Azure Portal](https://portal.azure.com/) and create a **Translator resource**.
2. Copy the following values:
    - **Key** → `AZURE_KEY` 🔑
    - **Region** → `AZURE_REGION` 🌍
    - **Endpoint** → `AZURE_ENDPOINT` 🌐
3. Create a `.env` file in the project root:
```env
AZURE_KEY=your_key_here
AZURE_REGION=your_region_here
AZURE_ENDPOINT=https://api.cognitive.microsofttranslator.com/
```

📬 Example Postman Requests:
1.🩺 Health Check
-GET /health
-Response:

```json
{
  "status": "Server is running successfully"
}
```

2.🌐 Translate Text
POST /translate
Content-Type: application/json
-Body:

```json
{
  "text": "Hello world",
  "to": "ar"
}
```

-Response:
```json
{
  "translatedText": "مرحبا بالعالم"
}
```

⚠️ Edge Cases:

1.Empty text:-

```json
{
  "text": "",
  "to": "ar"
}
```

-response:

```json
{
  "error": "Text cannot be empty"
}
```

2.Invalid target language:

```json
{
  "text": "Hello",
  "to": "xyz"
}
```

-Response:
```json
{
  "error": "Translation failed: ..."
}
```

