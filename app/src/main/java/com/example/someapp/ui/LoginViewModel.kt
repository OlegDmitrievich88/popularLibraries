package com.example.someapp.ui

import com.example.someapp.R
import com.example.someapp.domain.LoginUseCase
import com.example.someapp.utils.Publisher

class LoginViewModel(
    //private val api: LoginApi
    private val logiUsecase: LoginUseCase
) : LoginContract.ViewModel {
    override val showProgress: Publisher<Boolean> = Publisher()

    override val isSuccess: Publisher<Boolean> = Publisher()

    override val errorText: Publisher<String> = Publisher()


    // private var view: LoginContract.View? = null
    // private var isSuccess: Boolean = false
    // private val uiHandler = Handler(Looper.getMainLooper())


//    override fun onAttach(view: LoginContract.View) {
//        this.view = view
//        if (isSuccess) {
//            view.setSuccess()
//        }
//    }

    override fun onLogin(login: String, password: String) {
       // view?.setProgress()
        showProgress.post(true)

        logiUsecase.login(login, password) { result ->
            if (result) {

                showProgress.post(false)
                isSuccess.post(true)
            } else {
                errorText.post(R.string.ErrorLogin.toString())
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
       // view?.setProgress()
       // view?.setScreenForRegistration()
    }

    override fun onRegistration() {
       //view?.setProgress()
       // view?.setScreenForRegistration()
    }

//    private fun access(login: Boolean, password: Boolean) {
//        if (login) {
//
//        } else {
//            view?.setErrorLogin()
//        }
//    }
}