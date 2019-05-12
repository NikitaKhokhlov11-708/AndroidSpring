package com.example.androidspring

import com.arellomobile.mvp.InjectViewState


@InjectViewState
class MainPresenter : BasePresenter<MainView>() {
    fun getData() {
        makeNetworkRequest(request = {
            NetworkHandler.getService().getTestData().execute()
        }, onResult = { viewState.showResult(it) })
    }
}