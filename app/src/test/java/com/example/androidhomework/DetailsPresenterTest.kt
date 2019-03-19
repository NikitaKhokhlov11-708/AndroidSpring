package com.example.androidhomework

import com.example.androidhomework.presenters.DetailsPresenter
import com.example.androidhomework.views.DetailsView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {
    private lateinit var presenterTest: DetailsPresenter
    @Mock
    private lateinit var view: DetailsView

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenterTest = DetailsPresenter()
        presenterTest.attachView(view)
        presenterTest.showInfo("Test", "Test", "Test", "Test")
    }

    @Test
    fun showInfoTest() {
        verify(view).showInfo("Test", "Test", "Test", "Test")
    }
}