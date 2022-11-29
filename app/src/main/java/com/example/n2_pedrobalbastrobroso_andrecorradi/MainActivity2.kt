package com.example.n2_pedrobalbastrobroso_andrecorradi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val text = intent.getStringExtra("email")
        emailview.text = text.toString()
    }
}