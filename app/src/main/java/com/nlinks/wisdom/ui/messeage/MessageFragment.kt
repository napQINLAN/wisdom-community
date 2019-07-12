package com.nlinks.wisdom.ui.messeage

import com.nap.base.BaseFragment
import com.nlinks.wisdom.R

/**
 * @author chenqinlan
 * createTime 2019/7/11 0011
 * description
 */

class MessageFragment : BaseFragment<MessageViewModel>() {
    override fun providerVMClass(): Class<MessageViewModel>? = MessageViewModel::class.java
    override fun getLayoutResId() = R.layout.fragment_message

    override fun initView() {
    }

    override fun initData() {
    }

}