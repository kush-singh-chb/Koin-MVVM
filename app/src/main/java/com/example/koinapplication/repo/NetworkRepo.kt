package com.example.koinapplication.repo

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkRepo(service: NetworkService) : DataSource {

    var retrofit = service.getNetworkService()

    override fun listRepos(user: String, callback: DataSource.OnResponseCallback<Any, Any>) {
        val call: Call<List<Any>> = retrofit.listRepos(user)
        call.enqueue(object : Callback<List<Any>> {
            override fun onResponse(call: Call<List<Any>>, response: Response<List<Any>>) {
                callback.onSuccess("Success")
            }

            override fun onFailure(call: Call<List<Any>>, t: Throwable) {
                callback.onError("Error")
                Log.e("Throws", t.localizedMessage ?: "Error")
            }

        })
    }
}