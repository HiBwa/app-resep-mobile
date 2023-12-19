package com.fikri.resepmasakan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class ViewDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_detail)

        val back = findViewById<ImageButton>(R.id.imageButton)

        back.setOnClickListener(View.OnClickListener {
            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        })

    }
}