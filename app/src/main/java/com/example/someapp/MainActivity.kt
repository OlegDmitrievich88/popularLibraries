package com.example.someapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginContract.View {

    private var presenter: LoginContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        presenter = restorePresenter()
        presenter?.onAttach(this)

        button_enter.setOnClickListener{
            presenter?.onLogin(login_text.text.toString(),password_text.text.toString())
        }
        button_registration.setOnClickListener {
            presenter?.onRegistration()
        }
        button_forgot_my_password.setOnClickListener {
            presenter?.onChangePassword()
        }

    }

    private fun restorePresenter(): LoginPresenter {
        val presenter = lastCustomNonConfigurationInstance as? LoginPresenter
        return presenter ?: LoginPresenter()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? = presenter


    override fun setSuccess() {
        Toast.makeText(this,"good", Toast.LENGTH_SHORT).show()
        button_registration.isVisible = false
        button_forgot_my_password.isVisible = false
        container.setBackgroundColor(Color.RED)

    }

    override fun setErrorPassword() {
        Toast.makeText(this,R.string.ErrorPassword, Toast.LENGTH_SHORT).show()
    }

    override fun setErrorLogin() {
        Toast.makeText(this,R.string.ErrorLogin, Toast.LENGTH_SHORT).show()
    }

    override fun setProgress() {
        progress_bar.isVisible = true
    }

    override fun setScreenForRegistration() {
        Toast.makeText(this,R.string.setLogin, Toast.LENGTH_SHORT).show()
    }

    override fun setNewPassword() {
        Toast.makeText(this,R.string.setNewPassword, Toast.LENGTH_SHORT).show()
    }

    override fun removeProgress() {
        progress_bar.isVisible = false
    }


}