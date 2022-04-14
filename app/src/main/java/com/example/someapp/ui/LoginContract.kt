package com.example.someapp.ui

import androidx.annotation.MainThread
import com.example.someapp.utils.Publisher


interface LoginContract {

    interface ViewModel {

        val showProgress: Publisher<Boolean>
        val isSuccess: Publisher<Boolean>
        val errorText: Publisher<String>

        @MainThread
        fun onLogin(login: String, password: String)

        @MainThread
        fun onChangePassword()

        @MainThread
        fun onRegistration()

    }

//    interface View {
//        @MainThread
//        fun setSuccess()
//
//        @MainThread
//        fun setErrorPassword()
//
//        @MainThread
//        fun setErrorLogin()
//
//        @MainThread
//        fun setProgress()
//
//        @MainThread
//        fun setScreenForRegistration()
//
//        @MainThread
//        fun setNewPassword()
//
//        @MainThread
//        fun removeProgress()
//    }

//    interface Presenter {
//
//        @MainThread
//        fun onAttach(view: View)
//
//        @MainThread
//        fun onLogin(login: String, password: String)
//
//        @MainThread
//        fun onChangePassword()
//
//        @MainThread
//        fun onRegistration()
//
//    }
}