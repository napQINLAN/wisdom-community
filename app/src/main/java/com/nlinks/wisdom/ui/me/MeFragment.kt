package com.nlinks.wisdom.ui.messeage

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nap.base.BaseFragment
import com.nlinks.wisdom.R
import com.nlinks.wisdom.dp2px
import com.nlinks.wisdom.model.bean.me.MeMenuInfo
import com.nlinks.wisdom.ui.me.MeAdapter
import kotlinx.android.synthetic.main.fragment_me.*
import luyao.wanandroid.view.CustomLoadMoreView
import luyao.wanandroid.view.SpaceItemDecoration

/**
 * @author chenqinlan
 * createTime 2019/7/11 0011
 * description
 */

class MeFragment : BaseFragment<MeViewModel>() {

    private val meAdapter by lazy { MeAdapter() }
    override fun providerVMClass(): Class<MeViewModel>? = MeViewModel::class.java
    override fun getLayoutResId() = R.layout.fragment_me

    override fun initView() {
        rv_me.run {
            var layoutManager = LinearLayoutManager(activity)
            rv_me.layoutManager =layoutManager
            addItemDecoration(SpaceItemDecoration(rv_me.dp2px(10f)))
        }

        initAdapter()

    }

    private fun initAdapter() {
        meAdapter.run {
            setOnItemClickListener { _, _, position ->


            }
        }
        rv_me.adapter = meAdapter
    }

    override fun initData() {
        meAdapter.run {
            var dataList =ArrayList<MeMenuInfo>()
            dataList.add(0, MeMenuInfo(0,R.drawable.icon_company,"","会议管理"))
            dataList.add(1,MeMenuInfo(1,R.drawable.icon_company,"","推荐下载"))
            dataList.add(2,MeMenuInfo(2,R.drawable.icon_company,"","设置"))
            dataList.add(3,MeMenuInfo(3,R.drawable.icon_company,"","意见反馈"))
            replaceData(dataList)
        }
    }

}