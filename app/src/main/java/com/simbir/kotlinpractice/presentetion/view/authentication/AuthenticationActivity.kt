package com.simbir.kotlinpractice.presentetion.view.authentication

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.jakewharton.rxbinding4.widget.TextViewTextChangeEvent
import com.jakewharton.rxbinding4.widget.textChangeEvents
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.presentetion.presenter.AuthenticationPresenter
import com.simbir.kotlinpractice.presentetion.view.BaseActivity
import com.simbir.kotlinpractice.presentetion.view.mainactivity.MainActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import moxy.presenter.InjectPresenter

class AuthenticationActivity : BaseActivity(), AuthenticationView {

    @InjectPresenter
    lateinit var presenter: AuthenticationPresenter

    private val MIN_LETTERS_FOR_LOGIN_PASSWORD = 6

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var buttonLogin: Button

    private lateinit var disposable: Disposable

    override fun getActivityLayoutId(): Int {
        return R.layout.activity_authentication
    }

    override fun getActionBarId(): Int {
        return R.layout.action_bar_authentication
    }

    override fun initViews() {
        loginEditText = findViewById(R.id.eMailLoginAuthentication)
        passwordEditText = findViewById(R.id.passwordLoginAuthentication)
        buttonLogin = findViewById(R.id.loginButtonAuthentication)
    }

    override fun onStart() {
        super.onStart()
        disposable =
            Observable.combineLatest(
                loginEditText.textChangeEvents(),
                passwordEditText.textChangeEvents(),
                BiFunction<TextViewTextChangeEvent, TextViewTextChangeEvent, Boolean> { login, password ->
                    (login.text.length >= MIN_LETTERS_FOR_LOGIN_PASSWORD
                            && password.text.length >= MIN_LETTERS_FOR_LOGIN_PASSWORD)
                }
            )
                .subscribe { isValid: Boolean ->
                    val backgroundColor =
                        if (isValid) getColor(R.color.colorTitle) else getColor(R.color.authenticationButtonColorNonActive)
                    buttonLogin.setBackgroundColor(backgroundColor)
                    buttonLogin.isEnabled = isValid
                    buttonLogin.isClickable = isValid
                }
    }

    override fun onStop() {
        super.onStop()
        disposable.dispose()
    }

    fun onClickLoginAuthentication(view: View) {
        startActivity(Intent(this, MainActivity :: class.java))
        finish()
    }

    fun onClickAuthenticationBack(view: View) {
        finish()
    }
}