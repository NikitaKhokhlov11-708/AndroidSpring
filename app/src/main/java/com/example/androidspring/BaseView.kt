package com.example.androidspring

import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {
    fun showDialog()
    fun hideDialog()
    fun showError(text: String)
}