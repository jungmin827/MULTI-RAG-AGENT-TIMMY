package com.emailassistant.repository

import com.emailassistant.domain.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, Long> {
    fun findByUserIdAndEmail(userId: Long, email: String): Client?
    fun findByUserId(userId: Long): List<Client>
}

