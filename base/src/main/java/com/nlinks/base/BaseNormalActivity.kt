package com.nap.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.jaeger.library.StatusBarUtil
import com.nlinks.base.R
import kotlinx.android.synthetic.main.title_layout.*
import utils.RomUtils
import utils.StatusBarUtils

abstract class BaseNormalActivity : AppCompatActivity() {

    private var mDialog: MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView()
        if (mToolbar != null) {
            setSupportActionBar(mToolbar)
        }
        //强制竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //禁止键盘自动弹出
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        StatusBarUtils.setNoStatusBarFullMode(this, ContextCompat.getColor(this, R.color.colorPrimary))
        if (RomUtils.isMiui()) {
            StatusBarUtils.MIUISetStatusBarLightMode(window, true)
        } else if (RomUtils.isFlyme()) {
            StatusBarUtils.FlymeSetStatusBarLightMode(window, true)
        }
        initData()
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

    protected fun startActivity(z: Class<*>) {
        startActivity(Intent(this, z))
    }

    protected fun showProgressDialog(content: String) {
        if (mDialog == null)
            mDialog = MaterialDialog.Builder(this)
                .content(content).progress(true, 1)
                .canceledOnTouchOutside(false).build()
        else
            mDialog?.setContent(content)
        mDialog?.show()
    }

    protected fun showProgressDialog(resId: Int) {
        if (mDialog == null)
            mDialog = MaterialDialog.Builder(this)
                .content(getString(resId)).progress(true, 1)
                .canceledOnTouchOutside(false).build()
        else
            mDialog?.setContent(getString(resId))
        mDialog?.show()
    }

    protected fun dismissProgressDialog() {
        mDialog?.dismiss()
    }


}