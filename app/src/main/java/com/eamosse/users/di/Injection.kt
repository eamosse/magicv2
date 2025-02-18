package com.eamosse.users.di

import com.eamosse.users.api.FakeApiService
import com.eamosse.users.repository.UserRepository

object Injection {
    private var repository: UserRepository? = null

    @JvmStatic
    fun getRepository(): UserRepository {
        if (repository == null) {
            repository = UserRepository(FakeApiService())
        }
        return repository!!
    }
}