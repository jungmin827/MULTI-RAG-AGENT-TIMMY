package com.emailassistant.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "mail_contexts")
data class MailContext(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(nullable = false)
    val userId: Long,
    
    @Column(nullable = false)
    val clientId: Long,
    
    @Column(nullable = false)
    val gmailMessageId: String,
    
    val subject: String? = null,
    val body: String? = null,
    val intent: String? = null,
    val selectedDraft: String? = null,
    
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    
    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

