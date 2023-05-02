package com.example.aflammy.data.repository

import com.example.aflammy.data.remote.response.account.AccountDto


interface AccountRepository {

    fun getSessionId(): String?


    suspend fun loginWithUserNameANdPassword(userName: String, password: String) : Boolean

    suspend fun logout()

    suspend fun getAccountDetails(): AccountDto?
}

