package com.example.someapp.data

import com.example.someapp.domain.LoginApi

class FakeLoginApiImplementation : LoginApi {

    private val truePassword: String = "1"
    private val trueLogin: String = "1"

//    override fun login(login: String): Boolean {
//        Thread.sleep(1000)
//        return login == trueLogin
//    }

    override fun login(login: String, password: String): Boolean {
        Thread.sleep(1000)
        return login == trueLogin
    }

    override fun password(password: String): Boolean {
        Thread.sleep(1000)
        return password == truePassword
    }

    override fun registration(login: String, password: String, email: String): Boolean {
        Thread.sleep(1000)
        return true
    }

    override fun logOut(): Boolean {
        Thread.sleep(1000)
        return true
    }

    override fun forgotPassword(login: String): Boolean {
        Thread.sleep(1000)
        return false
    }
}