package com.example.androidspring

import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.*
import retrofit2.Response

open class BasePresenter<T : BaseView> : MvpPresenter<T>() {
    fun makeNetworkRequest(
        beforeRequest: () -> Unit = { showDialog() },
        afterRequest: () -> Unit = { hideDialog() },
        request: () -> Response<List<User>>,
        onResult: (result: List<User>) -> Unit,
        errorShow: (error: String) -> Unit = { t -> showError(t) }
    ): Job {
        return GlobalScope.launch(Dispatchers.Main) {
            beforeRequest()
            delay(1000)
            var result: Response<List<User>>? = null
            try {
                result = withContext(Dispatchers.Default) {
                    request()
                }
            } catch (ex: Throwable) {
                ex.printStackTrace()
                errorShow(ex.message.toString())
            }
            afterRequest()
            delay(1000)

            if (result != null) {
                val body = result.body()
                body?.let { onResult(it) }
            }
        }
    }

    fun showDialog() {
        viewState.showDialog()
    }

    fun hideDialog() {
        viewState.hideDialog()
    }

    fun showError(error: String) {
        viewState.showError(error)
    }
}