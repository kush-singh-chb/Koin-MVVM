package com.example.koinapplication.repo

class DataRepo(private val network: NetworkRepo /*Add Local repo */) : DataSource {
    override fun listRepos(user: String, callback: DataSource.OnResponseCallback<Any, Any>) {
        network.listRepos(user, callback)
    }
}