package com.example.someapp.ui

import android.os.Handler
import android.os.Looper
import com.example.someapp.domain.LoginApi
import com.example.someapp.domain.LoginUseCase
import java.lang.Thread.sleep

class LoginPresenter(
    //private val api: LoginApi
    private val logiUsecase: LoginUseCase
    ) : LoginContract.Presenter {

    private var view: LoginContract.View? = null
    private var isSuccess: Boolean = false
   // private val uiHandler = Handler(Looper.getMainLooper())


    override fun onAttach(view: LoginContract.View) {
        this.view = view
        if (isSuccess) {
            view.setSuccess()
        }
    }

    override fun onLogin(login: String, password: String) {
        view?.setProgress()

        logiUsecase.login(login,password){result ->
            if (result) {
                isSuccess = true
                view?.removeProgress()
                view?.setSuccess()
            } else {
                view?.setErrorPassword()
            }
        }

//        Thread {
//            val userLogin = api.login(login)
//            val userPassword = api.password(password)
//            sleep(3000)
//            uiHandler.post { access(userLogin, userPassword) }
//
//        }.start()

    }


    override fun onChangePassword() {
        view?.setProgress()
        view?.setScreenForRegistration()
    }

    override fun onRegistration() {
        view?.setProgress()
        view?.setScreenForRegistration()
    }

//    private fun access(login: Boolean, password: Boolean) {
//        if (login) {
//
//        } else {
//            view?.setErrorLogin()
//        }
//    }
}