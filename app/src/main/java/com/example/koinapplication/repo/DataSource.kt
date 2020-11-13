package com.example.koinapplication.repo

interface DataSource {
    interface OnResponseCallback<T,R> {
        fun onSuccess(obj: T)
        fun onError(error: R)
    }

    fun listRepos(user:String,callback: OnResponseCallback<Any,Any>)
}