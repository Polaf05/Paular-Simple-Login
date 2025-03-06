package com.example.simplelogin.data.repository.login

import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(/*Data Source Here*/){
    suspend fun login(email: String, password: String): Boolean {
        delay(2000) // Simulating network delay
        return email == "test@example.com" && password == "password123"
    }
}