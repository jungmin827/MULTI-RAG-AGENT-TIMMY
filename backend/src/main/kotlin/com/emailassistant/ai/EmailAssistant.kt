package com.emailassistant.ai

import dev.langchain4j.service.AiService
import dev.langchain4j.service.MemoryId
import dev.langchain4j.service.SystemMessage
import dev.langchain4j.service.UserMessage

@AiService
interface EmailAssistant {
    
    @SystemMessage("""
    You are a professional business email assistant.
    You must consider the user's profile and the client's context.
    Always generate 3 alternatives with different tones.
    """)
    fun generateReply(
        @UserMessage intent: String,
        @MemoryId clientId: String
    ): List<EmailDraft>
}

data class EmailDraft(
    val content: String,
    val tone: String,
    val riskPoints: List<String>
)

