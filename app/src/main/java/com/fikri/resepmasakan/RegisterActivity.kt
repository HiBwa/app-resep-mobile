package com.fikri.resepmasakan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val namaEdit  = findViewById<EditText>(R.id.nama)
        val usernameEdit  = findViewById<EditText>(R.id.username)
        val noHP  = findViewById<EditText>(R.id.no_hp)
        val passwordEdit  = findViewById<EditText>(R.id.password)
        val email  = findViewById<EditText>(R.id.email)
        val registerButton = findViewById<Button>(R.id.buttonRegister)
        val login = findViewById<TextView>(R.id.textLogin)


        registerButton.setOnClickListener(View.OnClickListener {
            val nama = namaEdit.text.toString()
            val username  = usernameEdit.text.toString()
            val noTelephone = noHP.text.toString()
            val email = email.text.toString()
            val  password = passwordEdit.text.toString()
            val register  = Intent(this, LoginActivity::class.java)
            startActivity(register)
        })
        login.setOnClickListener(View.OnClickListener {
            val login = Intent(this, LoginActivity::class.java)
            startActivity(login)
        })


    }

}






