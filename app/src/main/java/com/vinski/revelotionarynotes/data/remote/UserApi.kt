package com.vinski.revelotionarynotes.data.remote


import com.vinski.revelotionarynotes.data.remote.dto.RegisterDto
import com.vinski.revelotionarynotes.data.remote.dto.SignInDto
import com.vinski.revelotionarynotes.domain.model.AuthModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/api/register")
    suspend fun register(@Body body: RegisterDto): Response<AuthModel>

    @POST("/api/login")
    suspend fun login(@Body body: SignInDto): Response<AuthModel>
}