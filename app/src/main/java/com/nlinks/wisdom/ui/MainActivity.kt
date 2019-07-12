package com.nlinks.wisdom.ui

import android.content.Intent
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.afollestad.materialdialogs.MaterialDialog
import com.google.gson.Gson
import com.nap.base.BaseNormalActivity
import com.nlinks.wisdom.APP
import com.nlinks.wisdom.R
import com.nlinks.wisdom.model.bean.User
import com.nlinks.wisdom.ui.login.LoginActivity
import com.nlinks.wisdom.ui.messeage.MeFragment
import com.nlinks.wisdom.ui.messeage.MessageFragment
import com.nlinks.wisdom.ui.project.ProjectFragment
import com.nlinks.wisdom.utils.Preference
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseNormalActivity() {
    private var fragments = ArrayList<Fragment>()
    private var menuItem: MenuItem? = null
    private var isLogin by Preference(Preference.IS_LOGIN, false)
    private var userJson by Preference(Preference.USER_GSON, "")
    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {
        if (isLogin && userJson != "") {
            APP.CURRENT_USER = Gson().fromJson(userJson, User::class.java)
            val user = APP.CURRENT_USER
//            initUser(user)
        } else {
            MaterialDialog.Builder(this)
                .title("您还没有登录")
                .content("登录后可使用更多功能")
                .positiveText("去登录")
                .onPositive { _, _ ->
                    Intent(this, LoginActivity::class.java).run { startActivity(this) }
                }.show()

        }

        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            menuItem = item
            when (item.itemId) {
                R.id.i_project -> {
                    vp.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.i_message -> {
                    vp.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.i_personal -> {
                    vp.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false
        }
        fragments.add(ProjectFragment())
        fragments.add(MessageFragment())
        fragments.add(MeFragment())
        vp.adapter = HomeFragmentAdapter(supportFragmentManager, fragments!!)
        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            var nextPosition = -1
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                nextPosition = position
                if (nextPosition > 1) {
                    nextPosition++
                }
                bottomNavigation.currentItem = nextPosition
            }
        })

    }

    override fun initData() {
    }


}

