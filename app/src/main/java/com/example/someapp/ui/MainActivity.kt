package com.example.someapp.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.someapp.R
import com.example.someapp.app
import com.example.someapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private var presenter: LoginContract.Presenter? = null
    private var viewModel: LoginContract.ViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = restoreViewModel()
       // presenter = restorePresenter()
       // presenter?.onAttach(this)

        binding.buttonEnter.setOnClickListener {
            viewModel?.onLogin(
                binding.loginEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )

        }
        binding.buttonRegistration.setOnClickListener {
            viewModel?.onRegistration()
        }
        binding.buttonForgotMyPassword.setOnClickListener {
            viewModel?.onChangePassword()
        }
        viewModel?.showProgress?.subscribe { shouldShow->
            if (shouldShow == true){
                setProgress()
            }else{
                removeProgress()
            }

        }
        viewModel?.isSuccess?.subscribe {
            if (it == true){
                setSuccess()
            }
        }

    }

    private fun restoreViewModel(): LoginViewModel {
        val viewModel = lastCustomNonConfigurationInstance as? LoginViewModel
        //  val useCase: LoginUseCase = LoginUseCaseImplementation(app.api, Handler(Looper.getMainLooper()) )
        //return presenter ?: LoginPresenter(app.api)
        return viewModel ?: LoginViewModel(app.loginUseCase)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return viewModel
    }

    fun setSuccess() {
        Toast.makeText(this, "good", Toast.LENGTH_SHORT).show()
        with(binding) {
            buttonRegistration.isVisible = false
            buttonForgotMyPassword.isVisible = false
            container.setBackgroundColor(Color.RED)
        }


    }

     fun setErrorPassword() {
        Toast.makeText(this, R.string.ErrorPassword, Toast.LENGTH_SHORT).show()
    }

    fun setErrorLogin() {
        Toast.makeText(this, R.string.ErrorLogin, Toast.LENGTH_SHORT).show()
    }

    fun setProgress() {
        binding.progressBar.isVisible = true
    }

     fun setScreenForRegistration() {
        Toast.makeText(this, R.string.setLogin, Toast.LENGTH_SHORT).show()
    }

     fun setNewPassword() {
        Toast.makeText(this, R.string.setNewPassword, Toast.LENGTH_SHORT).show()
    }

     fun removeProgress() {
        binding.progressBar.isVisible = false
    }


}