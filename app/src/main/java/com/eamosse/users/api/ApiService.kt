package com.eamosse.users.api

import com.eamosse.users.model.User

interface ApiService {
    fun getUsers(): List<User>
    fun addRandomUser()
    fun deleteUser(username: User)
}