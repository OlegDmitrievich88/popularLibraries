package com.example.someapp

import android.os.Handler
import android.os.Looper
import java.lang.Thread.sleep

class LoginPresenter:LoginContract.Presenter {

    private var view: LoginContract.View? = null
    private val truePassword: String = "1"
    private val trueLogin: String = "1"
    private val uiHandler = Handler(Looper.getMainLooper())



    override fun onAttach(view: LoginContract.View) {
       this.view = view
    }

    override fun onLogin(login: String, passoword: String) {
        view?.setProgress()
            Thread{
                sleep(3000)
                uiHandler.post { access(login,passoword) }

            }.start()

    }



    override fun onChangePassword() {
        view?.setProgress()
        view?.setScreenForRegistration()
    }

    override fun onRegistration() {
        view?.setProgress()
        view?.setScreenForRegistration()
    }

    private fun access(login: String, password: String) {
        if (login == trueLogin) {
            if (password == truePassword) {
                view?.removeProgress()
                view?.setSuccess()
            } else {
                view?.setErrorPassword()
            }
        } else {
            view?.setErrorLogin()
        }
    }
}