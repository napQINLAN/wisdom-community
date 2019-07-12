package com.nlinks.wisdom.ui.project

import com.nap.base.BaseFragment
import com.nlinks.wisdom.R
import kotlinx.android.synthetic.main.fragment_project.*
import java.util.*


/**
 * @author chenqinlan
 * createTime 2019/7/11 0011
 * description
 */

class ProjectFragment : BaseFragment<ProjectViewModel>(){
    private val datasetStreet = LinkedList(listOf("东海街道", "丰泽街道", "鲤城街道"))
    private val datasetProject = LinkedList(listOf("东海项目", "丰泽项目", "鲤城项目"))
    override fun providerVMClass(): Class<ProjectViewModel>? = ProjectViewModel::class.java
    override fun getLayoutResId()=R.layout.fragment_project
    override fun initView() {
        tv_title.setText(R.string.important_project_management)
        nice_spinner_stree.attachDataSource(datasetStreet)
        nice_spinner_project.attachDataSource(datasetProject)
    }

    override fun initData() {
    }

}

