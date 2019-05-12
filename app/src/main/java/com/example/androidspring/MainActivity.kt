package com.example.androidspring

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : MvpAppCompatActivity(), MainView {

    val model = ViewModelProviders.of(this).get(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model.getUsers().observe(this, Observer<List<User>> {
                Toast.makeText(this@MainActivity, "Данные обновлены", Toast.LENGTH_SHORT).show()
        })
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
