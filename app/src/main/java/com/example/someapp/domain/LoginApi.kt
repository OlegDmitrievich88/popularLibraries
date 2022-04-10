package com.example.someapp.domain

interface LoginApi {
    fun login(login: String):Boolean
    fun password(password: String):Boolean
    fun registration(login: String, password: String, email: String): Boolean
    fun logOut():Boolean
    fun forgotPassword(login: String):Boolean
}