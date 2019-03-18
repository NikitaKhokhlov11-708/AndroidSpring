package com.example.androidhomework.views

import com.arellomobile.mvp.MvpView
import com.example.androidhomework.models.Book
import com.example.androidhomework.models.DataModel

interface MainView : MvpView {
    fun getBooks(query: String?)
    fun handleResponse(dataModel: DataModel?)
    fun handleError(error: Throwable)
    fun navigateToDetailsView(books: Book)
}