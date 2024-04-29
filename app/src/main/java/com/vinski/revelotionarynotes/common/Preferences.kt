package com.vinski.revelotionarynotes.common

import android.content.Context
import com.vinski.revelotionarynotes.common.Constants.AUTH_TOKEN
import com.vinski.revelotionarynotes.common.Constants.REMEMBER_USER
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(@ApplicationContext context: Context) {
    private var masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private var sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "secret_shared_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private var editor = sharedPreferences.edit()

    fun saveToken(token: String) {
        editor.putString(AUTH_TOKEN, token)
        editor.commit()
        editor.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(AUTH_TOKEN, "")
    }

    //remember user
    fun rememberStatus(): Boolean {
        return sharedPreferences.getBoolean(REMEMBER_USER, false)
    }

    fun setRememberUser(status: Boolean) {
        editor.putBoolean(REMEMBER_USER, status)
        editor.apply()
        editor.commit()

    }
}