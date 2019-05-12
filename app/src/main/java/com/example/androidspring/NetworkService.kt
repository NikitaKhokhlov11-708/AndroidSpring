package com.example.androidspring

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET
    fun getTestData(): Call<List<User>>
}