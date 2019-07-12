package com.example.mvvmapplication.model.api

import com.nap.base.BaseResponse
import com.nlinks.wisdom.model.bean.User
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Service {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

//    @GET("/article/list/{page}/json")
//    fun getHomeArticles(@Path("page") page: Int): Deferred<BaseResponse<ArticleList>>
//
//    @GET("/banner/json")
//    fun getBanner(): Deferred<BaseResponse<List<Banner>>>
//
//    @GET("/tree/json")
//    fun getSystemType(): Deferred<BaseResponse<List<SystemParent>>>
//
//    @GET("/article/list/{page}/json")
//    fun getSystemTypeDetail(@Path("page") page: Int, @Query("cid") cid: Int): Deferred<BaseResponse<ArticleList>>
//
//    @GET("/navi/json")
//    fun getNavigation(): Deferred<BaseResponse<List<Navigation>>>
//
//    @GET("/project/tree/json")
//    fun getProjectType(): Deferred<BaseResponse<List<SystemParent>>>
//
//    @GET("/wxarticle/chapters/json")
//    fun getBlogType(): Deferred<BaseResponse<List<SystemParent>>>
//
//    @GET("/wxarticle/list/{id}/{page}/json")
//    fun getBlogArticle(@Path("id") id: Int, @Path("page") page: Int): Deferred<BaseResponse<ArticleList>>
//
//    @GET("/project/list/{page}/json")
//    fun getProjectTypeDetail(@Path("page") page: Int, @Query("cid") cid: Int): Deferred<BaseResponse<ArticleList>>
//
//    @GET("/article/listproject/{page}/json")
//    fun getLastedProject(@Path("page") page: Int): Deferred<BaseResponse<ArticleList>>
//
//    @GET("/friend/json")
//    fun getWebsites(): Deferred<BaseResponse<List<Hot>>>
//
//    @GET("/hotkey/json")
//    fun getHot(): Deferred<BaseResponse<List<Hot>>>
//
//    @FormUrlEncoded
//    @POST("/article/query/{page}/json")
//    fun searchHot(@Path("page") page: Int, @Field("k") key: String): Deferred<BaseResponse<ArticleList>>

    @FormUrlEncoded
    @POST("/user/login")
    fun login(@Field("username") userName: String, @Field("password") passWord: String): Deferred<BaseResponse<User>>

    @FormUrlEncoded
    @POST("/user/register")
    fun register(@Field("username") userName: String, @Field("password") passWord: String, @Field("repassword") rePassWord: String): Deferred<BaseResponse<User>>

//    @GET("/lg/collect/list/{page}/json")
//    fun getCollectArticles(@Path("page") page: Int): Deferred<BaseResponse<ArticleList>>
//
//    @POST("/lg/collect/{id}/json")
//    fun collectArticle(@Path("id") id: Int): Deferred<BaseResponse<ArticleList>>
//
//    @POST("/lg/uncollect_originId/{id}/json")
//    fun cancelCollectArticle(@Path("id") id: Int): Deferred<BaseResponse<ArticleList>>


}