package com.example.androidhomework

import com.example.androidhomework.presenters.ZoomedPresenter
import com.example.androidhomework.views.ZoomedView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ZoomedPresenterTest {
    private lateinit var presenterTest: ZoomedPresenter
    @Mock
    private lateinit var view: ZoomedView

    @Before
    @Throws(Exception::class)
    fun setU() {
        MockitoAnnotations.initMocks(this)
        presenterTest = ZoomedPresenter()
        presenterTest.attachView(view)
    }

    @Test
    fun showInfoTest() {
        Mockito.verify(view).showImage("https://cs8.pikabu.ru/post_img/big/2016/02/04/7/145458292112119207.jpg")
    }
}