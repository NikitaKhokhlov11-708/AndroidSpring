package com.example.androidhomework.di

import com.example.androidhomework.ui.DetailsActivity
import com.example.androidhomework.ui.MainActivity
import com.example.androidhomework.ui.ZoomedActivity
import dagger.Component

@MainScope
@Component(dependencies = [AppComponent::class], modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(zoomedActivity: ZoomedActivity)

    fun inject(detailsActivity: DetailsActivity)
}