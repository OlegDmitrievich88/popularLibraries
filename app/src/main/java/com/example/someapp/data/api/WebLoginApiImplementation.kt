package com.example.someapp.data.api

import com.example.someapp.domain.LoginApi

class WebLoginApiImplementation : LoginApi {


    override fun login(login: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun password(password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun registration(login: String, password: String, email: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun logOut(): Boolean {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(login: String): Boolean {
        TODO("Not yet implemented")
    }
}