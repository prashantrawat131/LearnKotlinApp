package com.example.learnkotlinapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class LoginViewModel : ViewModel() {
    fun login(email: String, password: String) {
//        withContext(Dispatchers.IO)
    }
}