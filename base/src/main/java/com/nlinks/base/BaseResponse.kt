package com.nap.base

/**
 * 只保存数据的类
 */
data class BaseResponse <out T>(val errorCode: Int, val errorMsg: String, val data: T)