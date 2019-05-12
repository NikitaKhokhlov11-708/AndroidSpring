package com.example.androidspring

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    fun loadUsers() {
        GlobalScope.launch(Dispatchers.Main) {
            var result: Response<List<User>>? = null
            try {
                result = withContext(Dispatchers.Default) {
                    NetworkHandler.getService().getTestData().execute()
                }
            } catch (ex: Throwable) {
                ex.printStackTrace()
            }

            if (result != null) {
                val body = result.body()
                body?.let { it }
            }
        }
    }
}