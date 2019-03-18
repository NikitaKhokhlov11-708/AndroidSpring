package com.example.androidhomework.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.androidhomework.R
import com.example.androidhomework.presenters.ZoomedPresenter
import com.example.androidhomework.views.ZoomedView
import com.squareup.picasso.Picasso

class ZoomedActivity : MvpAppCompatActivity(), ZoomedView {

    @InjectPresenter
    lateinit var mZoomedPresenter: ZoomedPresenter

    private var ivZoomed: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoomed)

        ivZoomed = findViewById(R.id.iv_zoomed)

        val intent: Intent = getIntent()
        val url = intent.getStringExtra("url")

        mZoomedPresenter.showImage(url)
    }

    override fun showImage(url: String) {
        Picasso.get().load(url).into(ivZoomed)
    }
}