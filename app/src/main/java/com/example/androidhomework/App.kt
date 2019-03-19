package com.example.androidhomework

import android.app.Application
import com.arellomobile.mvp.MvpFacade
import com.example.androidhomework.di.AppComponent
import com.example.androidhomework.di.AppModule
import com.example.androidhomework.di.DaggerAppComponent
import com.example.androidhomework.di.NetModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MvpFacade.init()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule())
            .build()
    }

    companion object {

        var appComponent: AppComponent? = null
            private set
    }
}
