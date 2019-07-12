package com.nlinks.wisdom.model.repository

import com.example.mvvmapplication.model.api.RetrofitClient
import com.nap.base.BaseRepository
import com.nap.base.BaseResponse
import com.nlinks.wisdom.model.bean.User

/**
 * Created by luyao
 * on 2019/4/10 9:42
 */
class ProjectRepository : BaseRepository() {

    suspend fun login(userName: String, passWord: String): BaseResponse<User> {
        return apiCall { RetrofitClient.service.login(userName, passWord).await() }
    }

    suspend fun register(userName: String, passWord: String): BaseResponse<User> {
        return apiCall { RetrofitClient.service.register(userName, passWord, passWord).await() }
    }

}