package com.example.androidhomework.di

import com.example.androidhomework.component.DataAdapter
import com.example.androidhomework.presenters.DetailsPresenter
import com.example.androidhomework.presenters.MainPresenter
import com.example.androidhomework.presenters.ZoomedPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideDataAdapter(presenter: MainPresenter): DataAdapter = DataAdapter { presenter.onBookClick(it) }

    @Provides
    fun provideMainPresenter(): MainPresenter = MainPresenter()

    @Provides
    fun provideZoomPresenter(): ZoomedPresenter = ZoomedPresenter()

    @Provides
    fun provideDetails(): DetailsPresenter = DetailsPresenter()
}
