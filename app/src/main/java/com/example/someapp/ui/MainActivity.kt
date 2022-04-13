package com.example.someapp.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.someapp.R
import com.example.someapp.app
import com.example.someapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var binding: ActivityMainBinding
    private var presenter: LoginContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = restorePresenter()
        presenter?.onAttach(this)

        binding.buttonEnter.setOnClickListener {
            presenter?.onLogin(
                binding.loginEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )

        }
        binding.buttonRegistration.setOnClickListener {
            presenter?.onRegistration()
        }
        binding.buttonForgotMyPassword.setOnClickListener {
            presenter?.onChangePassword()
        }

    }

    private fun restorePresenter(): LoginPresenter {
        val presenter = lastCustomNonConfigurationInstance as? LoginPresenter
        //  val useCase: LoginUseCase = LoginUseCaseImplementation(app.api, Handler(Looper.getMainLooper()) )
        //return presenter ?: LoginPresenter(app.api)
        return presenter ?: LoginPresenter(app.loginUseCase)
    }

    @Deprecated("Deprecated in Java")
    override fun onRetainCustomNonConfigurationInstance(): Any? = presenter


    override fun setSuccess() {
        Toast.makeText(this, "good", Toast.LENGTH_SHORT).show()
        with(binding) {
            buttonRegistration.isVisible = false
            buttonForgotMyPassword.isVisible = false
            container.setBackgroundColor(Color.RED)
        }


    }

    override fun setErrorPassword() {
        Toast.makeText(this, R.string.ErrorPassword, Toast.LENGTH_SHORT).show()
    }

    override fun setErrorLogin() {
        Toast.makeText(this, R.string.ErrorLogin, Toast.LENGTH_SHORT).show()
    }

    override fun setProgress() {
        binding.progressBar.isVisible = true
    }

    override fun setScreenForRegistration() {
        Toast.makeText(this, R.string.setLogin, Toast.LENGTH_SHORT).show()
    }

    override fun setNewPassword() {
        Toast.makeText(this, R.string.setNewPassword, Toast.LENGTH_SHORT).show()
    }

    override fun removeProgress() {
        binding.progressBar.isVisible = false
    }


}