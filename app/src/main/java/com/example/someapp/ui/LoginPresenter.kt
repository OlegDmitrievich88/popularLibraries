package com.example.someapp.ui

import android.os.Handler
import android.os.Looper
import com.example.someapp.domain.LoginApi
import java.lang.Thread.sleep

class LoginPresenter(private val api: LoginApi) : LoginContract.Presenter {

    private var view: LoginContract.View? = null
  //  private val truePassword: String = "1"
  //  private val trueLogin: String = "1"
    private var isSuccess: Boolean = false
    private val uiHandler = Handler(Looper.getMainLooper())


    override fun onAttach(view: LoginContract.View) {
        this.view = view
        if (isSuccess){
            view.setSuccess()
        }
    }

    override fun onLogin(login: String, passoword: String) {
        view?.setProgress()
        Thread {
            val login = api.login(login)
            val password = api.password(passoword)
            sleep(3000)
            uiHandler.post { access(login,password) }

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

    private fun access(login: Boolean,password: Boolean) {
        if (login) {
            if (password) {
                isSuccess = true
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