package com.vinski.revelotionarynotes.di


import com.vinski.revelotionarynotes.common.Constants
import com.vinski.revelotionarynotes.data.remote.AuthInterceptor
import com.vinski.revelotionarynotes.data.remote.NotesApi
import com.vinski.revelotionarynotes.data.remote.UserApi
import com.vinski.revelotionarynotes.data.repository.AuthRepositoryImp
import com.vinski.revelotionarynotes.data.repository.NotesRepositoryImp
import com.vinski.revelotionarynotes.domain.repository.AuthRepository
import com.vinski.revelotionarynotes.domain.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }

    @Provides
    @Singleton
    fun providesUserApi(retrofitBuilder: Retrofit.Builder): UserApi {
        return retrofitBuilder.build().create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNotesApi(retrofitBuilder: Builder, okHttpClient: OkHttpClient): NotesApi {
        return retrofitBuilder.client(okHttpClient).build().create(NotesApi::class.java)
    }


    @Provides
    @Singleton
    fun providesAuthRepository(api: UserApi): AuthRepository {
        return AuthRepositoryImp(api)
    }

    @Provides
    @Singleton
    fun providesNotesRepository(api: NotesApi): NotesRepository {
        return NotesRepositoryImp(api)
    }
}