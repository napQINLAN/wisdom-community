package com.nlinks.wisdom.ui.project

import com.nap.base.BaseViewModel
import com.nlinks.wisdom.model.repository.ProjectRepository

/**
 * @author chenqinlan
 * createTime 2019/7/11 0011
 * description
 */

class ProjectViewModel : BaseViewModel(){

    private val repository by lazy { ProjectRepository() }

}