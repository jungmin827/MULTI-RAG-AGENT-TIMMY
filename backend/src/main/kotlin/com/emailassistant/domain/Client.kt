package com.emailassistant.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "clients")
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(nullable = false)
    val userId: Long,
    
    @Column(nullable = false)
    val email: String,
    
    val name: String? = null,
    val tone: String? = null,
    val previousMailSummary: String? = null,
    val sensitivePoints: String? = null,
    val relationshipTemperature: String? = null,
    
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    
    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

