package com.nlinks.wisdom.ui.login

import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.nap.base.BaseActivity
import com.nlinks.wisdom.APP
import com.nlinks.wisdom.R
import com.nlinks.wisdom.toast
import com.nlinks.wisdom.ui.MainActivity
import com.nlinks.wisdom.utils.Preference
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.title_layout.*

/**
 * @author chenqinlan
 * createTime 2019/7/11 0011
 * description
 */
class LoginActivity : BaseActivity<LoginViewModel>() {

    private lateinit var userName: String
    private lateinit var passWord: String
    private var isLogin by Preference(Preference.IS_LOGIN, false)
    private var userJson by Preference(Preference.USER_GSON, "")

    override fun providerVMClass(): Class<LoginViewModel>? = LoginViewModel::class.java
    override fun getLayoutResId() = R.layout.activity_login

    override fun initView() {
        toolbar_title.setText(R.string.login)
        login.setOnClickListener {
            if (checkInput()) {
                showProgressDialog(getString(R.string.is_logining))
                mViewModel.login(userName, passWord)
            }
        }
    }

    override fun startObserve() {
        mViewModel.apply {
            mLoginUser.observe(this@LoginActivity, Observer {
                isLogin = true
                APP.CURRENT_USER = it
                userJson = Gson().toJson(it)
                dismissProgressDialog()
                startActivity(MainActivity::class.java)
                finish()
            })

            errMsg.observe(this@LoginActivity, Observer {
                dismissProgressDialog()
                it?.run { toast(it) }
            })
        }
    }

    private fun checkInput(): Boolean {
        userName = userNameLayout.editText?.text.toString()
        passWord = pswLayout.editText?.text.toString()
        if (userName.isEmpty()) {
            userNameLayout.error = getString(R.string.please_input_username)
            return false
        }
        if (passWord.isEmpty()) {
            pswLayout.error = getString(R.string.please_input_psw)
            return false
        }
        return true
    }

    override fun initData() {
    }
}