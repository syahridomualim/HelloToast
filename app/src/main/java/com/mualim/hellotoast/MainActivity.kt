package com.mualim.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtView: TextView
    private var mCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtView = findViewById(R.id.txt_show_count)

        btn_toast.setOnClickListener(this)
        btn_count.setOnClickListener(this)
        btn_reset.setOnClickListener(this)

        if (savedInstanceState != null) {
            txtView.text = savedInstanceState.getString("key_string")
            mCount = savedInstanceState.getInt("key_result")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("key_result", mCount)
        outState.putString("key_string", txtView.text.toString())
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_toast -> Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
            R.id.btn_count -> count()
            R.id.btn_reset -> reset()
        }
    }

    private fun reset() {
        mCount = 0
        txtView.text = mCount.toString()
    }
    private fun count() {
        mCount++
        txtView.text = mCount.toString()
        mCount++
    }
}