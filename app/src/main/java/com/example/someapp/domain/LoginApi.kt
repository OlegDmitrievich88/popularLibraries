package com.example.someapp.domain

import androidx.annotation.WorkerThread

interface LoginApi {

    @WorkerThread
    fun login(login: String,password: String): Boolean

    @WorkerThread
    fun password(password: String): Boolean

    @WorkerThread
    fun registration(login: String, password: String, email: String): Boolean

    @WorkerThread
    fun logOut(): Boolean

    @WorkerThread
    fun forgotPassword(login: String): Boolean
}