package com.example.androidhomework.views

import com.arellomobile.mvp.MvpView

interface ZoomedView : MvpView {
    fun showImage(url: String)
}