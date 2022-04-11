package com.example.someapp

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.someapp.data.FakeLoginApiImplementation
import com.example.someapp.data.LoginUseCaseImplementation
import com.example.someapp.domain.LoginApi
import com.example.someapp.domain.LoginUseCase

class App : Application() {
    //val api: LoginApi by lazy { FakeLoginApiImplementation() }
    private val loginApi: LoginApi by lazy { FakeLoginApiImplementation() }
    val loginUseCase: LoginUseCase by lazy {
        LoginUseCaseImplementation(app.loginApi, Handler(Looper.getMainLooper()))
    }
}

val Context.app: App
    get() {
        return applicationContext as App
    }
