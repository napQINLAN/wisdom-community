package com.nlinks.wisdom.ui.messeage

import com.nap.base.BaseViewModel
import com.nlinks.wisdom.model.repository.MessageRepository

/**
 * @author chenqinlan
 * createTime 2019/7/11 0011
 * description
 */

class MessageViewModel  : BaseViewModel(){
    private val repository by lazy { MessageRepository() }

}