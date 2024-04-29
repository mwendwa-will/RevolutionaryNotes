package com.vinski.revelotionarynotes.domain.repository


import com.vinski.revelotionarynotes.data.remote.dto.RegisterDto
import com.vinski.revelotionarynotes.data.remote.dto.SignInDto
import com.vinski.revelotionarynotes.domain.model.AuthModel
import retrofit2.Response

interface AuthRepository {
    suspend fun signIn(body: SignInDto): Response<AuthModel>? = null
    suspend fun signUp(body: RegisterDto): Response<AuthModel>? = null
}