package com.example.androidhomework

import com.example.androidhomework.models.Book
import com.example.androidhomework.presenters.MainPresenter
import com.example.androidhomework.views.MainView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainPresenterTest {
    @Mock
    private lateinit var presenter: MainPresenter
    @Mock
    private lateinit var view: MainView
    private val testString: String = "Say Hello to my lil friend motherf*cker"

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter()
        presenter.attachView(view)
    }

    @Test
    @Throws(Exception::class)
    fun onItemClick() {
        val book = Mockito.mock(Book::class.java)
        presenter.onBookClick(book)
        Mockito.verify<Any>(view.navigateToDetailsView(book))
    }

    @Test
    @Throws(Exception::class)
    fun onFirstViewAttach() {
        Mockito.doNothing().`when`<Any>(presenter.loadXML())
        presenter.onFirstViewAttach()
        Mockito.verify<Any>(presenter.loadXML())
    }

    @Test
    fun testLoadXml() {
        verify(view).getBooks(testString)
    }

    @Test
    @Throws(Exception::class)
    fun doActionInView() {
        Mockito.verifyNoMoreInteractions(view)
    }
}