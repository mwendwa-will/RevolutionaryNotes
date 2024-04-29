package com.vinski.revelotionarynotes.data.repository


import com.vinski.revelotionarynotes.data.remote.UserApi
import com.vinski.revelotionarynotes.data.remote.dto.RegisterDto
import com.vinski.revelotionarynotes.data.remote.dto.SignInDto
import com.vinski.revelotionarynotes.domain.model.AuthModel
import com.vinski.revelotionarynotes.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(private val api: UserApi) : AuthRepository {
    override suspend fun signIn(body: SignInDto): Response<AuthModel> {
        return api.login(body)
    }

    override suspend fun signUp(body: RegisterDto): Response<AuthModel> {
        return api.register(body)
    }
}