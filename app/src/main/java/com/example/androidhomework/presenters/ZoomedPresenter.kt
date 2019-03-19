package com.example.androidhomework.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.androidhomework.views.ZoomedView

@InjectViewState
class ZoomedPresenter : MvpPresenter<ZoomedView>() {
    fun showImage(url: String) = viewState.showImage(url)
}
