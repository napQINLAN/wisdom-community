package com.nlinks.wisdom.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * 项目名称：minielectric-android
 * 类描述：TOOD
 * 创建时间：2018/5/21 17:20
 * @author gweibin@linewell.com
 */
class HomeFragmentAdapter(fm: FragmentManager?, fragments: List<Fragment>) : FragmentPagerAdapter(fm!!) {

    private val mFragments = fragments

    override fun getCount() = mFragments.size

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }


}