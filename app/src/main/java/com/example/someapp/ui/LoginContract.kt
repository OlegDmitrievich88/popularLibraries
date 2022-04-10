package com.example.someapp.ui

import androidx.annotation.MainThread


class LoginContract {

    interface View {
        @MainThread
        fun setSuccess()

        @MainThread
        fun setErrorPassword()

        @MainThread
        fun setErrorLogin()

        @MainThread
        fun setProgress()

        @MainThread
        fun setScreenForRegistration()

        @MainThread
        fun setNewPassword()

        @MainThread
        fun removeProgress()


    }

    interface Presenter {
        fun onAttach(view: View)
        fun onLogin(login: String, password: String)
        fun onChangePassword()
        fun onRegistration()

    }
}