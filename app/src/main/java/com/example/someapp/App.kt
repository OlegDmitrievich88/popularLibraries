package com.example.someapp

import android.app.Application
import android.content.Context
import com.example.someapp.data.FakeLoginApiImplementation
import com.example.someapp.data.WebLoginApiImplementation
import com.example.someapp.domain.LoginApi

class App: Application() {
    val api:LoginApi by lazy { FakeLoginApiImplementation() }
}

val Context.app: App
    get(){
        return applicationContext as App
    }
