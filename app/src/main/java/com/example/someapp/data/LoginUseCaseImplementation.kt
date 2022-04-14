package com.example.someapp.data

import android.os.Handler
import com.example.someapp.domain.LoginApi
import com.example.someapp.domain.LoginUseCase

class LoginUseCaseImplementation(
    private val api: LoginApi,
    private val uiHandler: Handler
) : LoginUseCase {

    override fun login(
        login: String,
        password: String,
        callback: (Boolean) -> Unit
    ) {
        Thread {
            val result = api.login(login,password)
           // val loginResult = api.login(login)
            //val passwordResult = api.password(password)
            uiHandler.post {
                callback(result)
               // callback(passwordResult)
            }
        }.start()
    }
}