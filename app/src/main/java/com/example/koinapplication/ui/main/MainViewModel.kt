package com.example.koinapplication.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.koinapplication.repo.DataRepo
import com.example.koinapplication.repo.DataSource
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewModel : ViewModel(), KoinComponent {
    private val dataRepo: DataRepo by inject()

    fun sayHello() {
        dataRepo.listRepos("kush-singh-chb", object : DataSource.OnResponseCallback<Any, Any> {
            override fun onSuccess(obj: Any) {
                Log.i("Calling Network Service", "got Response")
            }

            override fun onError(error: Any) {
                Log.i("Calling Network Service", "got Error")
            }
        })
    }
}