package com.example.androidspring

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getData()
    }

    override fun showDialog() {
        Toast.makeText(this, "Начало загрузки", Toast.LENGTH_SHORT).show()
    }

    override fun hideDialog() {
        Toast.makeText(this, "Конец загрузки", Toast.LENGTH_SHORT).show()
    }

    override fun showError(text: String) {
        Toast.makeText(this, "Произошла ошибка $text}", Toast.LENGTH_SHORT).show()
    }

    override fun showResult(list: List<User>) {
        Toast.makeText(this, "Данные получены: $list", Toast.LENGTH_SHORT).show()
    }
}
